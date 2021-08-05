package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearchapp.databinding.FragmentListBinding
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.ui.adapter.MoviesAdapter
import com.example.moviesearchapp.ui.adapter.listener.OnClickListener
import com.example.moviesearchapp.ui.extenstions.createAndShowWithoutAction
import com.example.moviesearchapp.viewmodel.ViewModel

class ListFragment : Fragment(), OnClickListener {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this@ListFragment).get(ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        if (savedInstanceState == null) {
            viewModel.requestMoviesList()
        }

        val upcomingAdapter = MoviesAdapter(this)
        val popularAdapter = MoviesAdapter(this)
        val topRatedAdapter = MoviesAdapter(this)

        with(binding.upcomingMovieList) {
            layoutManager = GridLayoutManager(
                requireContext(),
                SPAN_COUNT,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = upcomingAdapter
        }

        with(binding.popularMovieList) {
            layoutManager = GridLayoutManager(
                requireContext(),
                SPAN_COUNT,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = popularAdapter
        }

        with(binding.topRatedMovieList) {
            layoutManager = GridLayoutManager(
                requireContext(),
                SPAN_COUNT,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = topRatedAdapter
        }

        with(viewModel) {
            getLiveDataUpcoming().observe(viewLifecycleOwner) {
                upcomingAdapter.addMovies(it)
            }
            getLiveDataPopular().observe(viewLifecycleOwner) {
                popularAdapter.addMovies(it)
            }
            getLiveDataTopRated().observe(viewLifecycleOwner) {
                topRatedAdapter.addMovies(it)
            }
            getLiveDataError().observe(viewLifecycleOwner) {
                binding.fragmentListRoot.createAndShowWithoutAction(it.toString())
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(movie: Movie) {
        viewModel.onItemPressed(movie)
    }

    private companion object {
        private const val SPAN_COUNT = 1
    }
}