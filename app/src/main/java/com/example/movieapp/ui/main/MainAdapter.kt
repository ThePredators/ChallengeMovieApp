package com.example.movieapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.core.api.dtos.MovieDTO
import com.example.movieapp.core.data.entities.MovieEntity
import com.example.movieapp.databinding.MovieItemBinding

class MainAdapter(
    var listener: MovieListener
): RecyclerView.Adapter<MainViewHolder>() {

    private var movies: List<MovieEntity> = listOf()

    interface MovieListener {
        fun onMovieSelected(movieTitle: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: MovieItemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return MainViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size

    fun setMovies(movies: List<MovieEntity>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}