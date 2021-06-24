package com.example.movieapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.databinding.MovieDetailFragmentBinding
import com.example.movieapp.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: MovieDetailFragmentBinding
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(MainFragment.MOVIE_TITLE)?.let {
            viewModel.loadMovie(it).observe(viewLifecycleOwner, { movie ->
                binding.apply {
                    this.movie = movie
                }
            })
        }
    }

    companion object {
        fun newInstance() = MovieDetailFragment()
    }
}