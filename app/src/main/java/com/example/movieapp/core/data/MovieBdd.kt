package com.example.movieapp.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.core.data.daos.MovieDao
import com.example.movieapp.core.data.entities.MovieEntity

@Database(entities = [
    MovieEntity::class,
], version = 1, exportSchema = false)
abstract class MovieBdd : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}