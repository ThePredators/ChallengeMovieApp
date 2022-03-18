package com.example.movieapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class MainFragment : Fragment(), MainAdapter.MovieListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding
    private var mainAdapter: MainAdapter = MainAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moviesRv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mainAdapter
        }
        viewModel.movies.observe(viewLifecycleOwner) {
            mainAdapter.setMovies(it)
        }
    }

    override fun onMovieSelected(movieTitle: String) {
        val bundle = Bundle()
        bundle.putString(MOVIE_TITLE, movieTitle)
        findNavController().navigate(R.id.action_MovieListFragment_to_MovieDetailFragment, bundle)
    }

    companion object {
        var MOVIE_TITLE = "MOVIE_TITLE"
        fun newInstance() = MainFragment()
    }
}
