package com.example.mangaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mangaapp.databinding.ItemFavoriteMangaGridBinding
import com.example.mangaapp.mapper.Manga
import com.example.mangaapp.ui.favorites.FavoritesFragmentDirections
import com.example.mangaapp.ui.search.SearchFragmentDirections

class FavoritesAdapter :
    ListAdapter<Manga, FavoritesAdapter.MyViewHolder>(DiffCallback) {

    class MyViewHolder(var binding: ItemFavoriteMangaGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(manga: Manga) {
            binding.manga = manga
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Manga>() {
        override fun areItemsTheSame(
            oldItem: Manga,
            newItem: Manga
        ): Boolean {
            return oldItem.malId == newItem.malId
        }

        override fun areContentsTheSame(
            oldItem: Manga,
            newItem: Manga
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemFavoriteMangaGridBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val manga = getItem(position)
        holder.bind(manga)

        holder.binding.cardViewMangaItem.setOnClickListener {
            val action = FavoritesFragmentDirections.actionFavoritesFragmentToMangaDetailFragment(manga)
            Navigation.findNavController(it).navigate(action)
        }
    }
}