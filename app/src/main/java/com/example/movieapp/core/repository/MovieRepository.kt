package com.example.movieapp.core.repository

import androidx.lifecycle.liveData
import com.example.movieapp.core.api.datasource.RemoteMovieDataSource
import com.example.movieapp.core.data.datasource.LocalMovieDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(
    var localMovieDataSource: LocalMovieDataSource,
    var remoteMovieDataSource: RemoteMovieDataSource
) {

    fun loadMovies() = liveData(Dispatchers.IO) {
        val retrieveMovies = remoteMovieDataSource.getMovies()
        retrieveMovies.let {
            retrieveMovies.data?.let { data ->
                localMovieDataSource.insertMovies(data)
                emit(localMovieDataSource.getAllMovies())
            }
        }
    }

    fun loadMovie(movieTitle: String) = localMovieDataSource.getMovieByTitle(movieTitle)

}