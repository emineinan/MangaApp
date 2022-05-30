package com.example.mangaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.databinding.ItemMangaGridBinding
import com.example.mangaapp.databinding.ItemSearchMangaGridBinding
import com.example.mangaapp.mapper.Manga
import com.example.mangaapp.ui.home.HomeFragmentDirections
import com.example.mangaapp.ui.search.SearchFragmentDirections

class SearchAdapter :
    ListAdapter<Manga, SearchAdapter.MyViewHolder>(DiffCallback) {

    class MyViewHolder(var binding: ItemMangaGridBinding) :
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
        return MyViewHolder(ItemMangaGridBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val manga = getItem(position)
        holder.bind(manga)

        holder.binding.cardViewmangaItem.setOnClickListener {
           val action = SearchFragmentDirections.actionSearchFragmentToMangaDetailFragment(manga)
            Navigation.findNavController(it).navigate(action)
        }
    }
}