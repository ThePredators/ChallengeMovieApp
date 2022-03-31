package com.example.movieapp.core.data.datasource

import androidx.lifecycle.LiveData
import com.example.movieapp.core.api.dtos.MovieDTO
import com.example.movieapp.core.data.entities.MovieEntity

interface LocalMovieDataSource {
    suspend fun getAllMovies(): List<MovieEntity>
    suspend fun insertMovies(movies: List<MovieDTO>)
    fun getMovieByTitle(movieTitle: String): LiveData<MovieEntity>
}