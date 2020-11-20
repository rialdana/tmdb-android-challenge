package org.themoviedb.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.themoviedb.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    private val args by navArgs<MovieDetailFragmentArgs>()
    private val viewModel: MovieDetailViewModel by inject { parametersOf(args.movieId) }
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater).apply {
            viewModel = this@MovieDetailFragment.viewModel
            lifecycleOwner = this@MovieDetailFragment
        }

        return binding.root
    }
}