package com.example.mangaapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mangaapp.R
import com.example.mangaapp.databinding.FragmentMangaDetailBinding
import com.example.mangaapp.mapper.Manga
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : Fragment() {
    private lateinit var binding: FragmentMangaDetailBinding
    private val args: MangaDetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var manga: Manga

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMangaDetailBinding.inflate(layoutInflater)

        manga = args.manga!!
        binding.manga = manga

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabDetailFav.setOnClickListener {
            manga.isFavorite = true
            viewModel.setFavorite(manga)
            Toast.makeText(
                requireContext(),
                "${manga.title} added to favorites!",
                Toast.LENGTH_SHORT
            ).show()

            updateBackground(manga)
        }
    }

    private fun updateBackground(manga: Manga){
        if (manga.isFavorite) {
            binding.fabDetailFav.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.fabDetailFav.setImageResource(R.drawable.ic_favorite_non)
        }
    }
}