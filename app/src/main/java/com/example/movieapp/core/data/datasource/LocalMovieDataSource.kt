package com.example.movieapp.core.data.datasource

import androidx.lifecycle.LiveData
import com.example.movieapp.core.api.dtos.MovieDTO
import com.example.movieapp.core.data.daos.MovieDao
import com.example.movieapp.core.data.entities.MovieEntity
import timber.log.Timber
import javax.inject.Inject

class LocalMovieDataSource @Inject constructor(
    var movieDao: MovieDao
) {

    suspend fun getAllMovies() = movieDao.getAll()

    suspend fun insertMovies(movies: List<MovieDTO>) {
        var entityList: MutableList<MovieEntity> = mutableListOf()
        movies.map { dto ->
            entityList.add(MovieEntity(dto.title, dto.year, dto.director, dto.posterUrl))
        }
        Timber.d(entityList.toString())
        movieDao.insertAll(entityList)
    }

    fun getMovieByTitle(movieTitle: String): LiveData<MovieEntity> = movieDao.getMovieByTitle(movieTitle)
}