package com.example.moviesearchapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearchapp.R
import com.example.moviesearchapp.databinding.RowItemBinding
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.ui.adapter.listener.OnClickListener

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
            with(binding) {
                title.text = movie.title
                averageVote.text = movie.vote_average.toString()
                genre.text = movie.genre_ids.toString()
                //TODO(bind movie's poster)
            }

            itemView.setOnClickListener {
                onClickListener?.onClick(movie)
            }
        }
    }
}