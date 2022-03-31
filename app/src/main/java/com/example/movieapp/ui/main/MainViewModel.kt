package com.example.movieapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    movieRepository: MovieRepository
): ViewModel() {

//    init {
//        viewModelScope.launch {
//        }
//    }

    val movies = movieRepository.loadMovies()
}