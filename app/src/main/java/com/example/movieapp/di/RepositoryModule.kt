package com.example.movieapp.di

import com.example.movieapp.core.api.datasource.RemoteMovieDataSource
import com.example.movieapp.core.data.datasource.LocalMovieDataSource
import com.example.movieapp.core.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(localMovieDataSource: LocalMovieDataSource, remoteMovieDataSource: RemoteMovieDataSource): MovieRepository = MovieRepository(
        localMovieDataSource, remoteMovieDataSource)
}