package com.example.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movieapp.core.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    var repository: MovieRepository
) : ViewModel() {
    fun loadMovie(movieTitle: String) = repository.loadMovie(movieTitle)
}