package com.example.moviesearchapp.ui.adapters.listener

import com.example.moviesearchapp.domain.data.Movie

interface OnClickListener {
    fun onClick(movie: Movie)
}