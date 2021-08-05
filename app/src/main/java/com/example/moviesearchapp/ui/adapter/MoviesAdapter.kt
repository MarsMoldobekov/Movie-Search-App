package com.example.moviesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearchapp.R
import com.example.moviesearchapp.databinding.RowItemBinding
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.ui.adapter.listener.OnClickListener

class MoviesAdapter(
    private val onClickListener: OnClickListener,
    private val movies: MutableList<Movie> = mutableListOf()
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding get() = RowItemBinding.bind(itemView)

        fun bind(movie: Movie) {
            //TODO(bind movie's poster)
            binding.title.text = movie.title
            binding.averageVote.text = movie.vote_average.toString()
            binding.genre.text = movie.genre_ids.toString()
        }
    }
}