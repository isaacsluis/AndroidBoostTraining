package com.example.adroindboosttrading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.adroindboosttrading.databinding.ActivityMainBinding
import com.example.adroindboosttrading.model.MovieDbClient
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(
            emptyList()
        ) { movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT)
                .show()
        }

        binding.recycler.adapter = moviesAdapter

        // CORRUTINA SUSPENDIDA
        lifecycleScope.launch{
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }
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

