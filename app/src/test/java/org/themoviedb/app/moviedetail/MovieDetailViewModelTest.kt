package org.themoviedb.app.moviedetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.themobiedb.data.repository.MoviesRepository
import org.themobiedb.interactors.GetMovieDetail
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.moviedetail.MovieDetailViewModel
import org.themoviedb.util.BaseViewModelTest
import org.themoviedb.util.getOrAwaitValue
import org.themobiedb.data.Result.*
import org.themobiedb.model.moviedetail.BelongsToCollection
import org.themobiedb.model.moviedetail.MovieDetail

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest : BaseViewModelTest() {

    @get:Rule
    val coroutineRule = InstantTaskExecutorRule()

    private lateinit var movieDetailViewModel: MovieDetailViewModel
    private lateinit var moviesRepository: MoviesRepository

    @Before
    override fun setupViewModel() {

        super.setupViewModel()

        moviesRepository = mock(MoviesRepository::class.java)
        movieDetailViewModel =
            MovieDetailViewModel(GetMovieDetail(moviesRepository), 1)
    }

    @Test
    fun fetchMovieDetail_returnError() = runBlockingTest {
        val message = "Unable to fetch movie detail"

        `when`(moviesRepository.fetchMovieDetail(1)).thenReturn(
            Error(Exception(message))
        )

        movieDetailViewModel.fetchMovieDetail()

        val apiCallStatus = movieDetailViewModel.apiCallStatusOne.getOrAwaitValue()

        assertThat(apiCallStatus, `is`(ApiCallStatus.ERROR))
    }

    @Test
    fun fetchMovieDetail_returnSuccess() = runBlockingTest {

        val movieDetail = MovieDetail(
            true,
            "",
            BelongsToCollection("", 1, "", ""),
            0,
            emptyList(),
            "",
            1,
            "",
            "",
            "",
            "",
            4.1,
            "",
            emptyList(),
            emptyList(),
            "",
            2,
            2,
            emptyList(),
            "",
            "",
            "",
            false,
            4.4,
            2
        )

        `when`(moviesRepository.fetchMovieDetail(1)).thenReturn(
            Success(movieDetail)
        )

        movieDetailViewModel.fetchMovieDetail()

        val apiCallStatus = movieDetailViewModel.apiCallStatusOne.getOrAwaitValue()

        assertThat(apiCallStatus, `is`(ApiCallStatus.SUCCESS))

        assertThat(
            movieDetailViewModel.movieDetail.getOrAwaitValue().adult,
            `is`(movieDetail.adult)
        )

        assertThat(
            movieDetailViewModel.movieDetail.getOrAwaitValue().title,
            `is`(movieDetail.title)
        )
    }
}