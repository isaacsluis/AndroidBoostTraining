package com.example.adroindboosttrading

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.adroindboosttrading.databinding.ActivityMainBinding
import com.example.adroindboosttrading.model.Movie
import com.example.adroindboosttrading.model.MovieDbClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(emptyList()) { movie -> navigateTo(movie)}

        binding.recycler.adapter = moviesAdapter

        // CORRUTINA SUSPENDIDA
        lifecycleScope.launch{
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }
    }

    // esta funcion nos lleva a la navegacion de la nueva activity
    private fun navigateTo(movie: Movie) {

        val intent = Intent(this,DetailActivity::class.java)
         intent.putExtra(DetailActivity.EXTRA_MOVIE,movie)

        startActivity(intent)

    }
}



// para probar la API



// hilo creado para la prueba de la API
//        thread {

//            this.resources.getString(R.string.api_key)    la forma larga de llegar a recursos

//            esto se utilizo para realizar la prueba del llamado del api
/*
val apiKey = getString(R.string.api_key)
val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
val body = popularMovies.execute().body()
if (body != null) {
    Log.d("MainActivity", "Movie count ${body.results.size}")
} else {
    Log.d("MainActivity", "No funciono $body")
}
*/
//        }

