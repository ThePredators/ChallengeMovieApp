package com.example.movieapp.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.core.api.dtos.MovieDTO
import com.example.movieapp.core.data.entities.MovieEntity
import com.example.movieapp.databinding.MovieItemBinding

class MainViewHolder(
    var binding: MovieItemBinding,
    var listener: MainAdapter.MovieListener
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var selectedMovie: MovieEntity

    init {
        binding.setClickListener {
            listener.onMovieSelected(selectedMovie.title)
        }
    }

    fun bind(movie: MovieEntity) {
        selectedMovie = movie
        binding.apply {
            this.movie = movie
        }
    }
}