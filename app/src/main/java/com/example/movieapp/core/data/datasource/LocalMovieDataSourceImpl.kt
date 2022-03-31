package com.example.movieapp.core.data.datasource

import androidx.lifecycle.LiveData
import com.example.movieapp.core.api.dtos.MovieDTO
import com.example.movieapp.core.data.daos.MovieDao
import com.example.movieapp.core.data.entities.MovieEntity
import timber.log.Timber
import javax.inject.Inject

class LocalMovieDataSourceImpl @Inject constructor(
    var movieDao: MovieDao
): LocalMovieDataSource {

    override suspend fun getAllMovies() = movieDao.getAll()

    override suspend fun insertMovies(movies: List<MovieDTO>) {
        var entityList: MutableList<MovieEntity> = mutableListOf()
        movies.map { dto ->
            entityList.add(MovieEntity(dto.title, dto.year, dto.director, dto.posterUrl))
        }
        Timber.d(entityList.toString())
        movieDao.insertAll(entityList)
    }

    override fun getMovieByTitle(movieTitle: String): LiveData<MovieEntity> = movieDao.getMovieByTitle(movieTitle)
}