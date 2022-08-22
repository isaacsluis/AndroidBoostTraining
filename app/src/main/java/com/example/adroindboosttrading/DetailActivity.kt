package com.example.adroindboosttrading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.example.adroindboosttrading.databinding.ActivityDetailBinding
import com.example.adroindboosttrading.model.Movie

class DetailActivity : AppCompatActivity() {

    // los datos para que se pinte esta nueva activity

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recuperar el intent y pasar variables concretas

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            title = movie.title
            binding.title.text = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780${movie.backdrop_path}")
                .into(binding.backdrop)
            binding.summary.text = movie.overview
            bindingDetailInfo(binding.detailinfo,movie)
        }
    }

    private fun bindingDetailInfo(detailinfo: TextView, movie: Movie) {
        detailinfo.text = buildSpannedString {
            bold { append("Original Lenguaje: ") } // negrita
            appendLine(movie.original_language)

            bold{append("Original Title: ")}
            appendLine(movie.original_title)

            bold{append("Popularity: ")}
            appendLine(movie.popularity.toString())

            bold { append("Vote Average: ") }
            appendLine(movie.vote_average.toString())
        }

    }
}