package org.themoviedb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.themobiedb.model.movies.Movies
import org.themobiedb.data.Result
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.data.repository.MoviesRepository
import org.themobiedb.model.moviedetail.MovieDetail
import org.themobiedb.model.movies.Movie
import org.themoviedb.database.MovieDao
import org.themoviedb.database.MovieEntity

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesDataSource,
    private val movieDao: MovieDao
) : MoviesRepository {

    override suspend fun fetchPopularMovies(): Result<List<Movie>> = withContext(Dispatchers.IO) {
        try {
            val movies = remoteDataSource.fetchPopularMovies()

            movieDao.insertMovies(movies.results.map {
                MovieEntity(
                    it.id,
                    it.title,
                    it.overview,
                    it.posterPath,
                    MovieEntity.POPULAR_MOVIE
                )
            })

            Result.Success(
                movieDao.getMovies(MovieEntity.POPULAR_MOVIE).map { it.mapToDomainModel() })
        } catch (e: Exception) {
            val movies = movieDao.getMovies(MovieEntity.POPULAR_MOVIE)

            if (movies.isEmpty()) {
                Result.Error(e)
            } else {
                Result.Success(movies.map { it.mapToDomainModel() })
            }

        }
    }

    override suspend fun fetchTopRatedMovies(): Result<List<Movie>> = withContext(Dispatchers.IO) {
        try {
            val movies = remoteDataSource.fetchTopRatedMovies()

            movieDao.insertMovies(movies.results.map {
                MovieEntity(
                    it.id,
                    it.title,
                    it.overview,
                    it.posterPath,
                    MovieEntity.TOP_RATED_MOVIE
                )
            })

            Result.Success(
                movieDao.getMovies(MovieEntity.TOP_RATED_MOVIE).map { it.mapToDomainModel() }
            )
        } catch (e: Exception) {
            val movies = movieDao.getMovies(MovieEntity.TOP_RATED_MOVIE)

            if (movies.isEmpty()) {
                Result.Error(e)
            } else {
                Result.Success(movies.map { it.mapToDomainModel() })
            }
        }
    }

    override suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail> {
        return remoteDataSource.fetchMovieDetail(movieId)
    }

    override suspend fun searchMovie(query: String): Result<Movies> {
        return remoteDataSource.searchMovie(query)
    }

}