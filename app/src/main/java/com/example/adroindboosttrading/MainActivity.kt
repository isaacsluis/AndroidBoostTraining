package com.example.adroindboosttrading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.adroindboosttrading.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1","https://loremflickr.com/320/240?lock=1"),
                Movie("Title 2","https://loremflickr.com/320/240?lock=2"),
                Movie("Title 3","https://loremflickr.com/320/240?lock=3"),
                Movie("Title 4","https://loremflickr.com/320/240?lock=4"),
                Movie("Title 5","https://loremflickr.com/320/240?lock=5"),
                Movie("Title 6","https://loremflickr.com/320/240?lock=6"),
                Movie("Title 7","https://loremflickr.com/320/240?lock=7")
            )
        )   /// identifica como se pintan las vistas

    }
}

