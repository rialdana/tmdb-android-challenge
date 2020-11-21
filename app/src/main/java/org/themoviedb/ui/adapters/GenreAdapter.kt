package org.themoviedb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.themobiedb.model.moviedetail.Genre
import org.themoviedb.databinding.ItemGenreBinding
import org.themoviedb.framework.utils.GenericAdapter

class GenreAdapter() :
    ListAdapter<Genre, GenreAdapter.CharactersViewHolder>(DiffCallback),
    GenericAdapter<List<Genre>> {

    /**
     * DiffCallback algorithm to check when the item of the view changed
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(
            oldItem: Genre,
            newItem: Genre
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Genre,
            newItem: Genre
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class CharactersViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genre: Genre) {
            binding.genre = genre
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemGenreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val genre = getItem(position)
        holder.bind(genre)
    }

    override fun setData(data: List<Genre>) {
        submitList(data)
    }
}
