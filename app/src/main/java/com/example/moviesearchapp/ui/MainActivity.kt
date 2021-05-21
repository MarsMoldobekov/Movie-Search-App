package com.example.moviesearchapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesearchapp.R

class MainActivity : AppCompatActivity() {
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button?.setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    button?.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
        }
    }
}