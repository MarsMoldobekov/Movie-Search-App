package com.example.moviesearchapp.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.moviesearchapp.R
import com.example.moviesearchapp.viewmodel.AppStateLoading
import com.example.moviesearchapp.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {
    companion object {
        private const val IS_LIST_OF_GENRES_LOADED = "IS_LIST_OF_GENRES_LOADED"
        private const val IS_LIST_OF_COUNTRIES_LOADED = "IS_LIST_OF_COUNTRIES_LOADED"
        private const val IS_LIST_OF_LANGUAGES_LOADED = "IS_LIST_OF_LANGUAGES_LOADED"
    }

    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this).get(ViewModel::class.java)
    }

    private val sharedPreferences: SharedPreferences = getPreferences(MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!sharedPreferences.getBoolean(IS_LIST_OF_GENRES_LOADED, false)) {
            viewModel.loadGenres()
        }

        if (!sharedPreferences.getBoolean(IS_LIST_OF_COUNTRIES_LOADED, false)) {
            viewModel.loadCountries()
        }

        if (!sharedPreferences.getBoolean(IS_LIST_OF_LANGUAGES_LOADED, false)) {
            viewModel.loadLanguages()
        }

        with(viewModel) {
            getLiveDataLoadingGenres().observe(this@MainActivity) {
                realizeType(it, IS_LIST_OF_GENRES_LOADED)
            }
            getLiveDataLoadingCountries().observe(this@MainActivity) {
                realizeType(it, IS_LIST_OF_COUNTRIES_LOADED)
            }
            getLiveDataLoadingLanguages().observe(this@MainActivity) {
                realizeType(it, IS_LIST_OF_LANGUAGES_LOADED)
            }
        }
    }

    private fun realizeType(appStateLoading: AppStateLoading?, loadingData: String) {
        when (appStateLoading) {
            is AppStateLoading.Error -> {
                //TODO(implement reloading)
                sharedPreferences.edit().putBoolean(loadingData, false).apply()
            }
            is AppStateLoading.Success -> {
                sharedPreferences.edit().putBoolean(loadingData, true).apply()
            }
            AppStateLoading.Loading -> {
                //do nothing
            }
        }
    }
}