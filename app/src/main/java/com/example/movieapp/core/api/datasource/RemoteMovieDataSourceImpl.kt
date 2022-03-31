package com.example.movieapp.core.api.datasource

import com.example.movieapp.core.api.BaseAPI
import fr.freekit.movies.api.services.RemoteMovieService
import javax.inject.Inject

class RemoteMovieDataSourceImpl @Inject constructor(
    private val client: RemoteMovieService
): BaseAPI(), RemoteMovieDataSource {
    override suspend fun getMovies() = getResult { client.getMovies() }
}