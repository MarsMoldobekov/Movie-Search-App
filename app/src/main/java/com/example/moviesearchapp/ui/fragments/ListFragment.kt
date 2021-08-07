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

    private val upcomingAdapter = MoviesAdapter(this)
    private val popularAdapter = MoviesAdapter(this)
    private val topRatedAdapter = MoviesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        if (savedInstanceState == null) {
            viewModel.requestMoviesList()
        }

        with(binding) {
            with(upcomingMovieList) {
                layoutManager = createGridLayoutManager()
                adapter = upcomingAdapter
            }
            with(popularMovieList) {
                layoutManager = createGridLayoutManager()
                adapter = popularAdapter
            }
            with(topRatedMovieList) {
                layoutManager = createGridLayoutManager()
                adapter = topRatedAdapter
            }
        }

        with(viewModel) {
            getLiveDataUpcoming().observe(viewLifecycleOwner) {
                upcomingAdapter.movies = it
            }
            getLiveDataPopular().observe(viewLifecycleOwner) {
                popularAdapter.movies = it
            }
            getLiveDataTopRated().observe(viewLifecycleOwner) {
                topRatedAdapter.movies = it
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
        popularAdapter.removeListener()
        upcomingAdapter.removeListener()
        topRatedAdapter.removeListener()
    }

    override fun onClick(movie: Movie) {
        viewModel.onItemPressed(movie)
    }

    private fun createGridLayoutManager() = GridLayoutManager(
        requireContext(),
        1,
        RecyclerView.HORIZONTAL,
        false
    )
}