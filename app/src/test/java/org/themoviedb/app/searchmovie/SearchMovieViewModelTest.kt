package org.themoviedb.app.searchmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
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
import org.themobiedb.interactors.SearchMovies
import org.themobiedb.model.movies.Movies
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.searchmovie.SearchMovieViewModel
import org.themoviedb.util.BaseViewModelTest
import org.themoviedb.util.getOrAwaitValue

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchMovieViewModelTest : BaseViewModelTest() {
    @get:Rule
    val coroutineRule = InstantTaskExecutorRule()

    private lateinit var searchMoviesViewModel: SearchMovieViewModel
    private lateinit var moviesRepository: MoviesRepository

    private val query = "Test query"

    @Before
    override fun setupViewModel() {

        super.setupViewModel()

        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        searchMoviesViewModel = SearchMovieViewModel(SearchMovies(moviesRepository), query)
    }

    @Test
    fun getMovieResults_returnError() = runBlockingTest {
        Mockito.`when`(moviesRepository.searchMovie(query)).thenReturn(
            Result.Error(Exception(""))
        )

        searchMoviesViewModel.getMovieResults()

        val apiCallStatus = searchMoviesViewModel.apiCallStatusOne.getOrAwaitValue()

        assertThat(apiCallStatus, `is`(ApiCallStatus.ERROR))
    }

    @Test
    fun getMovieResults_returnSuccess() = runBlockingTest {
        val moviesResponse = Movies(1, emptyList(), 1, 0)
        Mockito.`when`(moviesRepository.searchMovie(query)).thenReturn(
            Result.Success(moviesResponse)
        )

        searchMoviesViewModel.getMovieResults()

        val apiCallStatus = searchMoviesViewModel.apiCallStatusOne.getOrAwaitValue()

        assertThat(apiCallStatus, `is`(ApiCallStatus.SUCCESS))
        assertThat(searchMoviesViewModel.movies.getOrAwaitValue(), `is`(moviesResponse))
    }
}