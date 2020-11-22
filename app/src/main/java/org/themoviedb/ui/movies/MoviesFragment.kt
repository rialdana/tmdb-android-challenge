package org.themoviedb.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import org.themoviedb.R
import org.themoviedb.databinding.FragmentMoviesBinding
import org.themoviedb.framework.utils.hideKeyboard
import org.themoviedb.framework.utils.showSnackbar
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

        binding.imageButtonSearch.setOnClickListener {
            validateInput()
        }

        binding.editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                validateInput()
                true
            } else {
                false
            }
        }

        return binding.root
    }

    private fun validateInput() {
        if (binding.editTextSearch.text.toString().isEmpty()) {
            binding.root.showSnackbar(getString(R.string.please_complete_field))
            return
        }

        hideKeyboard()
        openSearchScreen()
    }

    private fun openSearchScreen() {
        this.findNavController()
            .navigate(MoviesFragmentDirections.searchMovieAction(binding.editTextSearch.text.toString()))
    }

    private fun moviesClickListener() = MoviesAdapter.OnClickListener {
        this.findNavController().navigate(MoviesFragmentDirections.openMovieDetailAction(it.id))
    }

}