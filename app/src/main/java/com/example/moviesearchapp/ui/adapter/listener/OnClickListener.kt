package com.example.moviesearchapp.ui.adapter.listener

import com.example.moviesearchapp.domain.data.Movie

interface OnClickListener {
    fun onClick(movie: Movie)
}