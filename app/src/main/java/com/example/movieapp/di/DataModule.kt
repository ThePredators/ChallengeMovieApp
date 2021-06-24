package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.core.data.MovieBdd
import com.example.movieapp.core.data.daos.MovieDao
import com.example.movieapp.core.data.datasource.LocalMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): MovieBdd {
        return Room.databaseBuilder(appContext, MovieBdd::class.java, "db-movies")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieBdd): MovieDao = db.movieDao()

    @Provides
    fun provideLocalMovieDataSource(movieDao: MovieDao): LocalMovieDataSource =
        LocalMovieDataSource(movieDao)
}