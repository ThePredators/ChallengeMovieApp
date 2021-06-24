package com.example.movieapp.core.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entity")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "director") val director: String,
    @ColumnInfo(name = "posterUrl") val posterUrl: String
)
