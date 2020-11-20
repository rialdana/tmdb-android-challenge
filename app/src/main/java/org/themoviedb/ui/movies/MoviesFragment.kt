package org.themoviedb.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import org.themoviedb.databinding.FragmentMoviesBinding
import org.themoviedb.ui.adapters.MoviesAdapter

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMoviesBinding.inflate(inflater).apply {
            viewModel = this@MoviesFragment.viewModel
            lifecycleOwner = this@MoviesFragment
        }

        binding.recyclerViewMovies.adapter = MoviesAdapter(moviesClickListener())

        binding.recyclerViewPopularMovies.adapter = MoviesAdapter(moviesClickListener())



        return binding.root
    }

    private fun moviesClickListener() = MoviesAdapter.OnClickListener {

    }

}