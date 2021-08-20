package com.example.moviesearchapp.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviesearchapp.ui.fragments.ListsFragment
import com.example.moviesearchapp.ui.fragments.MoviesListsFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = MoviesListsFragment.TABS_COUNT

    override fun createFragment(position: Int): Fragment =
        ListsFragment.newInstance(Bundle().apply { putInt(ListsFragment.ARG_LIST, position) })
}