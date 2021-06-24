package com.example.movieapp.core.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.core.data.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_entity")
    suspend fun getAll(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie_entity WHERE title = :movieTitle")
    fun getMovieByTitle(movieTitle: String): LiveData<MovieEntity>
}