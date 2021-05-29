package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.moviesearchapp.R
import com.example.moviesearchapp.databinding.FragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.navigationView.setOnNavigationItemSelectedListener(this@MainFragment)
        return binding.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_list -> {
                Toast.makeText(requireContext(), "List", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item_favourite -> {
                Toast.makeText(requireContext(), "Favourite", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item_home -> {
                Toast.makeText(requireContext(), "Home", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}