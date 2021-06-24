package com.example.movieapp.core.api.datasource

import com.example.movieapp.core.api.BaseAPI
import fr.freekit.movies.api.services.RemoteMovieService
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(
    private val client: RemoteMovieService
): BaseAPI() {
    suspend fun getMovies() = getResult { client.getMovies() }
}