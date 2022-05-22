package com.example.mangaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.databinding.ItemMangaGridBinding
import com.example.mangaapp.ui.home.HomeFragmentDirections

class MangaAdapter :
    ListAdapter<MangaResponsesData, MangaAdapter.MyViewHolder>(DiffCallback) {

    class MyViewHolder(var binding: ItemMangaGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(manga: MangaResponsesData) {
            binding.manga = manga
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MangaResponsesData>() {
        override fun areItemsTheSame(
            oldItem: MangaResponsesData,
            newItem: MangaResponsesData
        ): Boolean {
            return oldItem.mal_id == newItem.mal_id
        }

        override fun areContentsTheSame(
            oldItem: MangaResponsesData,
            newItem: MangaResponsesData
        ): Boolean {
            return oldItem.images?.jpg?.largeImageUrl == newItem.images?.jpg?.largeImageUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemMangaGridBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val manga = getItem(position)
        holder.bind(manga)

        holder.binding.cardViewmangaItem.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(manga)
            Navigation.findNavController(it).navigate(action)
        }
    }
}