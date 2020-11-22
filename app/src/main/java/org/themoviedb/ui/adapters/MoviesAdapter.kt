package org.themoviedb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.themobiedb.model.movies.Movie
import org.themoviedb.databinding.ItemMovieBinding
import org.themoviedb.framework.utils.GenericAdapter

class MoviesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Movie, MoviesAdapter.CharactersViewHolder>(DiffCallback),
    GenericAdapter<List<Movie>> {

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

    class CharactersViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

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
