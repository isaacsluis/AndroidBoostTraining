package com.example.adroindboosttrading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.adroindboosttrading.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.message.text = "Elemento creado con binding inflado"

        //forma clasica de llamar un componente
        /* setContentView(R.layout.activity_main)
        val message = findViewById<TextView>(R.id.message)
        message.text = "Ya no quiero saludar a Android"  */

        Log.d("MainActivity","onCreate") // Tag de seguimiento
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity","onDestroy") // Tag de seguimiento
    }
}

