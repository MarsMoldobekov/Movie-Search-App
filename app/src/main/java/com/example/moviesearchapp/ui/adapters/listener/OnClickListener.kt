package com.example.moviesearchapp.ui.adapters.listener

import com.example.moviesearchapp.domain.net.data.Movie

interface OnClickListener {
    fun onClick(movie: Movie)
}