package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviesearchapp.R
import com.example.moviesearchapp.databinding.FragmentMoviesListsBinding
import com.example.moviesearchapp.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MoviesListsFragment : Fragment() {
    companion object {
        const val POPULAR_TAB_POSITION: Int = 0
        const val TOP_RATED_TAB_POSITION: Int = 1
        const val UPCOMING_TAB_POSITION: Int = 2
        const val TABS_COUNT: Int = 3
    }

    private var _binding: FragmentMoviesListsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            //TODO(reason = handle icons)
            when(position) {
                POPULAR_TAB_POSITION -> tab.setText(R.string.popular)
                TOP_RATED_TAB_POSITION -> tab.setText(R.string.top_rated)
                UPCOMING_TAB_POSITION -> tab.setText(R.string.upcoming)
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}