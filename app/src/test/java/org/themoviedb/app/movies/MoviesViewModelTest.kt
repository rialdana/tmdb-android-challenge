package org.themoviedb.app.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.themobiedb.data.Result
import org.themobiedb.data.repository.MoviesRepository
import org.themobiedb.interactors.GetPopularMovies
import org.themobiedb.interactors.GetTopRatedMovies
import org.themobiedb.model.movies.Movies
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.movies.MoviesViewModel
import org.themoviedb.util.BaseViewModelTest
import org.themoviedb.util.getOrAwaitValue

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest : BaseViewModelTest() {
    @get:Rule
    val coroutineRule = InstantTaskExecutorRule()

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var moviesRepository: MoviesRepository

    @Before
    override fun setupViewModel() {

        super.setupViewModel()

        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        moviesViewModel =
            MoviesViewModel(GetTopRatedMovies(moviesRepository), GetPopularMovies(moviesRepository))
    }

    @Test
    fun loadTopRatedMovies_returnError() = runBlockingTest {
        val message = "Unable to fetch movies"

        Mockito.`when`(moviesRepository.fetchTopRatedMovies()).thenReturn(
            Result.Error(Exception(message))
        )

        moviesViewModel.loadTopRatedMovies()

        val apiCallStatus = moviesViewModel.apiCallStatusOne.getOrAwaitValue()

        MatcherAssert.assertThat(apiCallStatus, `is`(ApiCallStatus.ERROR))
    }

    @Test
    fun loadTopRatedMovies_returnSuccess() = runBlockingTest {

        val movies = Movies(1, emptyList(), 1, 0)

        Mockito.`when`(moviesRepository.fetchTopRatedMovies()).thenReturn(
            Result.Success(movies)
        )

        moviesViewModel.loadTopRatedMovies()

        val apiCallStatus = moviesViewModel.apiCallStatusOne.getOrAwaitValue()

        MatcherAssert.assertThat(apiCallStatus, `is`(ApiCallStatus.SUCCESS))

        MatcherAssert.assertThat(
            moviesViewModel.topRatedMovies.getOrAwaitValue().results,
            `is`(movies.results)
        )

        MatcherAssert.assertThat(
            moviesViewModel.topRatedMovies.getOrAwaitValue().page,
            `is`(movies.page)
        )
    }

    @Test
    fun loadPopularMovies_returnError() = runBlockingTest {
        val message = "Unable to fetch movies"

        Mockito.`when`(moviesRepository.fetchPopularMovies()).thenReturn(
            Result.Error(Exception(message))
        )

        moviesViewModel.loadPopularMovies()

        val apiCallStatus = moviesViewModel.apiCallStatusTwo.getOrAwaitValue()

        MatcherAssert.assertThat(apiCallStatus, `is`(ApiCallStatus.ERROR))
    }

    @Test
    fun loadPopularMovies_returnSuccess() = runBlockingTest {

        val movies = Movies(1, emptyList(), 1, 0)

        Mockito.`when`(moviesRepository.fetchPopularMovies()).thenReturn(
            Result.Success(movies)
        )

        moviesViewModel.loadPopularMovies()

        val apiCallStatus = moviesViewModel.apiCallStatusTwo.getOrAwaitValue()

        MatcherAssert.assertThat(apiCallStatus, `is`(ApiCallStatus.SUCCESS))

        MatcherAssert.assertThat(
            moviesViewModel.popularMovies.getOrAwaitValue().results,
            `is`(movies.results)
        )

        MatcherAssert.assertThat(
            moviesViewModel.popularMovies.getOrAwaitValue().page,
            `is`(movies.page)
        )
    }


}