package com.example.mangaapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mangaapp.R
import com.example.mangaapp.databinding.FragmentMangaDetailBinding

class MangaDetailFragment : Fragment() {
    private lateinit var binding: FragmentMangaDetailBinding
    private val args: MangaDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMangaDetailBinding.inflate(layoutInflater)

        val manga = args.manga
        binding.manga = manga

        return binding.root
    }
}