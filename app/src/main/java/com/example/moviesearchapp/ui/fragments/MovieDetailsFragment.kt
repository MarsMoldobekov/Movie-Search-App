package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviesearchapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesearchapp.domain.net.data.MovieDetails
import com.example.moviesearchapp.viewmodel.ViewModel

class MovieDetailsFragment : DialogFragment() {
    companion object {
        const val MOVIE_DETAILS_TAG = "Movie Details Tag"

        fun newInstance() = MovieDetailsFragment()
    }

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this@MovieDetailsFragment).get(ViewModel::class.java)

        with(viewModel) {
            getLiveDataMovieDetails().observe(viewLifecycleOwner) {
                displayDetails(it)
            }
            getLiveDataMovieDetailsError().observe(viewLifecycleOwner) {
                displayError(it)
            }
        }

        return binding.root
    }

    private fun displayError(throwable: Throwable?) {
        //TODO(reason = display error)
    }

    private fun displayDetails(movieDetails: MovieDetails?) {
        //TODO(reason = display details)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}