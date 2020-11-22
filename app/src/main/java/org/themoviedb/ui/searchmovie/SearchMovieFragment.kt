package org.themoviedb.ui.searchmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.themoviedb.databinding.FragmentSearchMovieBinding
import org.themoviedb.ui.adapters.SearchMoviesAdapter

class SearchMovieFragment : Fragment() {

    private lateinit var binding: FragmentSearchMovieBinding
    private val args by navArgs<SearchMovieFragmentArgs>()
    private val viewModel by inject<SearchMovieViewModel> { parametersOf(args.query) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchMovieBinding.inflate(inflater).apply {
            viewModel = this@SearchMovieFragment.viewModel
            lifecycleOwner = this@SearchMovieFragment.viewLifecycleOwner
        }

        binding.recyclerViewSearchResult.adapter = SearchMoviesAdapter(getSearchMoviesCallback())

        return binding.root
    }

    private fun getSearchMoviesCallback() = SearchMoviesAdapter.OnClickListener {
        this.findNavController()
            .navigate(SearchMovieFragmentDirections.openMovieDetailFromSearchAction(it.id))
    }

}