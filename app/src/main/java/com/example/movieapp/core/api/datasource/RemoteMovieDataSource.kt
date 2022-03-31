package com.example.movieapp.core.api.datasource

import com.example.movieapp.core.api.Resource
import com.example.movieapp.core.api.dtos.MovieDTO

interface RemoteMovieDataSource {
    suspend fun getMovies(): Resource<List<MovieDTO>>
}