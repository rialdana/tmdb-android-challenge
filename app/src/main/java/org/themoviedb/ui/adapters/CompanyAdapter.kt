package org.themoviedb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.themobiedb.model.moviedetail.ProductionCompany
import org.themoviedb.databinding.ItemCompanyBinding
import org.themoviedb.framework.utils.GenericAdapter

class CompanyAdapter() :
    ListAdapter<ProductionCompany, CompanyAdapter.CharactersViewHolder>(DiffCallback),
    GenericAdapter<List<ProductionCompany>> {

    /**
     * DiffCallback algorithm to check when the item of the view changed
     */
    companion object DiffCallback : DiffUtil.ItemCallback<ProductionCompany>() {
        override fun areItemsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class CharactersViewHolder(private val binding: ItemCompanyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(company: ProductionCompany) {
            binding.company = company
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val company = getItem(position)
        holder.bind(company)
    }

    override fun setData(data: List<ProductionCompany>) {
        submitList(data)
    }
}
