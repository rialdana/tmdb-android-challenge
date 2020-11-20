package org.themoviedb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.themobiedb.core.domain.movies.Movie
import org.themoviedb.databinding.ItemMovieBinding
import org.themoviedb.framework.utils.GenericAdapter

/**
 * Adapter created to display movies
 */
class MoviesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Movie, MoviesAdapter.CharactersViewHolder>(DiffCallback),
    GenericAdapter<List<Movie>> {

    /**
     * DiffCallback algorithm to check when the item of the view changed
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * ViewHolder to bind each character to its respective data binding class
     */
    class CharactersViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    /**
     * ClickListener that returns a character every time the function is called
     */
    class OnClickListener(private val clickListener: (movie: Movie) -> Unit) {
        fun onCharacterClicked(movie: Movie) = clickListener(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val movie = getItem(position)

        holder.itemView.setOnClickListener {
            onClickListener.onCharacterClicked(movie)
        }

        holder.bind(movie)
    }

    override fun setData(data: List<Movie>) {
        submitList(data)
    }
}
