package com.example.movieapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.core.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var movieRepository: MovieRepository
): ViewModel() {
    val movies = movieRepository.loadMovies()
}