package com.example.mangaapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private var isSearchedFavorite = false

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

        manga.malId?.let { viewModel.searchFavoriteManga(it) }
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.searchedManga.observe(viewLifecycleOwner) { searchedManga ->
            if (searchedManga != null) {
                if (searchedManga.isFavorite) {
                    isSearchedFavorite = true
                    binding.buttonDetailFav.setBackgroundResource(R.drawable.ic_favorite)
                }
            } else {
                isSearchedFavorite = false
            }
        }
    }

    private fun initListener() {
        binding.buttonDetailFav.setOnCheckedChangeListener { _, _ ->
            if (!isSearchedFavorite) {
                manga.isFavorite = true
                binding.buttonDetailFav.setBackgroundResource(R.drawable.ic_favorite)
                viewModel.setFavorite(manga)
            } else if (isSearchedFavorite) {
                binding.buttonDetailFav.setBackgroundResource(R.drawable.ic_favorite_non)
                viewModel.deleteFavorite(manga)
            }
            isSearchedFavorite = !isSearchedFavorite
        }
    }
}