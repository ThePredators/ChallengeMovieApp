package fr.freekit.movies.api.services

import com.example.movieapp.core.api.dtos.MovieDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RemoteMovieService {

    @Headers("Content-Type: application/json")
    @GET("movies.json")
    suspend fun getMovies(): Response<List<MovieDTO>>
}