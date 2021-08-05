package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.moviesearchapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesearchapp.viewmodel.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MovieDetailsFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        viewModel.getLiveDataMovieDetails().observe(requireActivity()) {
            //TODO(display movieDetails)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}