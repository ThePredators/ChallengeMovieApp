package com.example.movieapp.di

import com.example.movieapp.core.api.datasource.RemoteMovieDataSource
import com.example.movieapp.core.api.datasource.RemoteMovieDataSourceImpl
import com.example.movieapp.core.data.datasource.LocalMovieDataSource
import com.example.movieapp.core.data.datasource.LocalMovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceInjection {

    @Binds
    abstract fun bindRemoteMovieDataSource(
        remoteMovieDataSourceImpl: RemoteMovieDataSourceImpl
    ): RemoteMovieDataSource

    @Binds
    abstract fun bindLocalMovieDataSource(
        localMovieDataSourceImpl: LocalMovieDataSourceImpl
    ): LocalMovieDataSource
}
