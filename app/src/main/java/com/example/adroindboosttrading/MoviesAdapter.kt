package com.example.adroindboosttrading

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adroindboosttrading.databinding.ViewMovieItemBinding
import com.example.adroindboosttrading.model.Movie

class MoviesAdapter(
    var movies: List<Movie>,
    val movieClickedListener: (Movie) -> Unit  ///lamnda agregada para la ejecucion de una accion de click sobre la imagen de los recycleview
) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

//          LayoutInflater
//          .from(parent.context)
//          .inflate(
//              R.layout.view_movie_item,
//              parent,
//              false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = movies[position] /// variable extraida con ctrl + alt + v
        holder.bind(movie)
        holder.bind(movie)
        holder.itemView.setOnClickListener { movieClickedListener(movie) }
    }

    override fun getItemCount() = movies.size

    class ViewHolder(val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.titleMovie.text = movie.title
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w185${movie.poster_path}")
                .into(binding.cover)

        }
    }


//    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}