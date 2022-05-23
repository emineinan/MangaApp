package com.example.mangaapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.databinding.FragmentMangaDetailBinding
import com.example.mangaapp.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : Fragment() {
    private lateinit var binding: FragmentMangaDetailBinding
    private val args: MangaDetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var manga: MangaResponsesData

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
            viewModel.setFavorite(
                FavoritesEntity(
                    manga.mal_id,
                    manga.title,
                    manga.images?.jpg?.largeImageUrl,
                    manga.scored
                )
            )
            Toast.makeText(
                requireContext(),
                "${manga.title} added to favorites!",
                Toast.LENGTH_SHORT
            ).show()

            navigateHome()
        }
    }


    private fun navigateHome() {
        val action = MangaDetailFragmentDirections.actionMangaDetailFragmentToHomeFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }
}