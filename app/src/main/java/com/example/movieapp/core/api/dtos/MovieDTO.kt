package com.example.movieapp.core.api.dtos

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("year")
    val year: Int = 1111,
    @SerializedName("director")
    val director: String  = "",
    @SerializedName("posterUrl")
    val posterUrl: String = ""
)
