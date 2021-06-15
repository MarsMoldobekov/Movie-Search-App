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
import com.example.moviesearchapp.ui.adapter.MoviesAdapter
import com.example.moviesearchapp.ui.listener.RecyclerItemClickListener
import com.example.moviesearchapp.viewmodel.ViewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        if (savedInstanceState == null) {
            viewModel.requestMoviesList()
        }

        val upcomingAdapter = MoviesAdapter()
        val popularAdapter = MoviesAdapter()
        val topRatedAdapter = MoviesAdapter()

        with(binding.upcomingMovieList) {
            layoutManager = GridLayoutManager(
                requireContext(),
                SPAN_COUNT,
                RecyclerView.HORIZONTAL,
                false
            )
            addOnItemTouchListener(
                RecyclerItemClickListener(
                    context,
                    binding.upcomingMovieList,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClicked(view: View, position: Int) {
                            //TODO(implement onItemClicked event)
                        }

                        override fun onLongItemClicked(view: View, position: Int) {

                        }
                    })
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
            addOnItemTouchListener(
                RecyclerItemClickListener(
                    context,
                    binding.popularMovieList,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClicked(view: View, position: Int) {
                            //TODO(implement onItemClicked event)
                        }

                        override fun onLongItemClicked(view: View, position: Int) {

                        }
                    }
                )
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
            addOnItemTouchListener(
                RecyclerItemClickListener(
                    context,
                    binding.topRatedMovieList,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClicked(view: View, position: Int) {
                            //TODO(implement onItemClicked event)
                        }

                        override fun onLongItemClicked(view: View, position: Int) {

                        }
                    }
                )
            )
            adapter = topRatedAdapter
        }

        viewModel.getLiveDataUpcoming().observe(requireActivity()) {
            upcomingAdapter.addMovies(it)
        }

        viewModel.getLiveDataPopular().observe(requireActivity()) {
            popularAdapter.addMovies(it)
        }

        viewModel.getLiveDataTopRated().observe(requireActivity()) {
            topRatedAdapter.addMovies(it)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val SPAN_COUNT = 1
    }
}