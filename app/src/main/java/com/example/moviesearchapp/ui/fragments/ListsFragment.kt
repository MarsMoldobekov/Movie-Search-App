package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesearchapp.databinding.FragmentListsBinding
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.ui.adapters.MoviesAdapter
import com.example.moviesearchapp.ui.adapters.listener.OnClickListener
import com.example.moviesearchapp.viewmodel.ViewModel

class ListsFragment : Fragment(), OnClickListener {
    private enum class TabsTypes {
        Upcoming, Popular, TopRated
    }

    companion object {
        const val ARG_LIST = "list"

        fun newInstance(bundle: Bundle) = ListsFragment().apply { arguments = bundle }
    }

    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this@ListsFragment).get(ViewModel::class.java)
    }

    private val moviesAdapter = MoviesAdapter(this)
    private lateinit var tabsTypes: TabsTypes

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListsBinding.inflate(inflater, container, false)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_LIST) }?.apply {
            tabsTypes = when (this.getInt(ARG_LIST)) {
                MoviesListsFragment.POPULAR_TAB_POSITION -> {
                    viewModel.requestPopular()
                    TabsTypes.Popular
                }
                MoviesListsFragment.TOP_RATED_TAB_POSITION -> {
                    viewModel.requestTopRated()
                    TabsTypes.TopRated
                }
                MoviesListsFragment.UPCOMING_TAB_POSITION -> {
                    viewModel.requestUpcoming()
                    TabsTypes.Upcoming
                }
                else -> throw IllegalArgumentException("Wrong argument: ${this.getInt(ARG_LIST)}")
            }
        }

        when(tabsTypes) {
            TabsTypes.Upcoming -> {
                viewModel.getLiveDataUpcoming().observe(viewLifecycleOwner) {
                    moviesAdapter.movies = it
                }
            }
            TabsTypes.Popular -> {
                viewModel.getLiveDataPopular().observe(viewLifecycleOwner) {
                    moviesAdapter.movies = it
                }
            }
            TabsTypes.TopRated -> {
                viewModel.getLiveDataTopRated().observe(viewLifecycleOwner) {
                    moviesAdapter.movies = it
                }
            }
        }

        viewModel.getLiveDataError().observe(viewLifecycleOwner) {
            //TODO(reason = handle exception)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        moviesAdapter.removeReferences()
    }

    override fun onClick(movie: Movie) {
        //TODO("Not yet implemented")
    }
}