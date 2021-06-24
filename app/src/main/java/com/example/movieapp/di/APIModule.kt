package com.example.movieapp.di

import com.example.movieapp.BuildConfig
import com.example.movieapp.core.api.datasource.RemoteMovieDataSource
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.freekit.movies.api.services.RemoteMovieService
import okhttp3.CipherSuite.Companion.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    private var TIMEOUT: Long = 90

    @Provides
    fun provideLogsInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(
        logsInterceptor: Interceptor
    ): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS) // connect timeout 90
            .readTimeout(TIMEOUT, TimeUnit.SECONDS) // socket timeout
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectionSpecs(Collections.singletonList(
                ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .cipherSuites(
                        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
                    ).build()
            ))
            .addInterceptor(logsInterceptor)
        if (BuildConfig.ENABLE_DEBUG) {
            okBuilder.addNetworkInterceptor(StethoInterceptor())
        }
        return okBuilder.build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideRemoteMoviesService(retrofit: Retrofit): RemoteMovieService = retrofit.create(RemoteMovieService::class.java)

    @Provides
    fun provideRemoteMovieDataSource(remoteMovieService: RemoteMovieService): RemoteMovieDataSource =
        RemoteMovieDataSource(remoteMovieService)

}

