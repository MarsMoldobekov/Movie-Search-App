package com.example.moviesearchapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearchapp.R
import com.example.moviesearchapp.databinding.RowItemBinding
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.ui.adapters.listener.OnClickListener
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private var onClickListener: OnClickListener?
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: List<Movie>? = null
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun removeReferences() {
        onClickListener = null
        movies = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding get() = RowItemBinding.bind(itemView)

        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.voteAverage.text = movie.vote_average.toString()
            Picasso.get().load("http://image.tmdb.org/t/p/w500/${movie.poster_path}")
                .into(binding.imgMoviePicture)

            itemView.setOnClickListener {
                onClickListener?.onClick(movie)
            }
        }
    }
}