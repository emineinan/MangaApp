package com.example.mangaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.databinding.ItemFavoriteMangaGridBinding

class FavoritesAdapter :
    ListAdapter<FavoritesEntity, FavoritesAdapter.MyViewHolder>(DiffCallback) {

    class MyViewHolder(private var binding: ItemFavoriteMangaGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(manga: FavoritesEntity) {
            binding.manga = manga
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FavoritesEntity>() {
        override fun areItemsTheSame(
            oldItem: FavoritesEntity,
            newItem: FavoritesEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: FavoritesEntity,
            newItem: FavoritesEntity
        ): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemFavoriteMangaGridBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val manga = getItem(position)
        holder.bind(manga)
    }
}