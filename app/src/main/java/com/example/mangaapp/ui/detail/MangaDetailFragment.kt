package com.example.mangaapp.ui.detail

import android.os.Bundle
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

        binding.buttonDetailFav.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && !manga.isFavorite) {
                manga.isFavorite = true
                binding.buttonDetailFav.setBackgroundResource(R.drawable.ic_favorite)
                viewModel.setFavorite(manga)
                Toast.makeText(
                    requireContext(),
                    "${manga.title} added to favorites!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                manga.isFavorite = false
                binding.buttonDetailFav.setBackgroundResource(R.drawable.ic_favorite_non)
                viewModel.deleteFavorite(manga)
                Toast.makeText(
                    requireContext(),
                    "${manga.title} removed from favorites!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}