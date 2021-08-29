package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviesearchapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesearchapp.viewmodel.AppStateLoadingMovieDetails
import com.example.moviesearchapp.viewmodel.ViewModel

class MovieDetailsFragment : DialogFragment() {
    companion object {
        const val MOVIE_DETAILS_TAG = "Movie Details Tag"

        fun newInstance() = MovieDetailsFragment()
    }

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this@MovieDetailsFragment).get(ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)

        viewModel.getLiveDataMovieDetails().observe(viewLifecycleOwner) {
            realizeType(it)
        }

        return binding.root
    }

    private fun realizeType(appStateLoadingMovieDetails: AppStateLoadingMovieDetails?) {
        when (appStateLoadingMovieDetails) {
            is AppStateLoadingMovieDetails.Error -> {
                //TODO(show an error)
            }
            AppStateLoadingMovieDetails.Loading -> {
                //TODO(show 'loading' layout)
            }
            is AppStateLoadingMovieDetails.Success -> {
                //TODO(show movie's details)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}