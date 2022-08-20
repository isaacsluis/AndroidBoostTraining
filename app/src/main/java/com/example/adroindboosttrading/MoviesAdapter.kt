package com.example.adroindboosttrading

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adroindboosttrading.databinding.ViewMovieItemBinding

class MoviesAdapter(private val movies: List<Movie>) :
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
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    class ViewHolder(val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie) {
            binding.titleMovie.text = movie.title
            Glide.with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)

        }
    }



//    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}