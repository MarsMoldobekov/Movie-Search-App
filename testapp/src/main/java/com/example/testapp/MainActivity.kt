package com.example.testapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var textViewFirstName: TextView? = null
    private var textViewLastName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewFirstName = findViewById(R.id.textViewFirstName)
        textViewLastName = findViewById(R.id.textViewLastName)

        val user = User(firstName = "Anna", lastName = "Sergeevna")
        val secondUser = user.copy(firstName = "Alexandr", lastName = "Petrov")

        textViewFirstName?.text = secondUser.firstName
        textViewLastName?.text = secondUser.lastName

        doSomethingInCycle()
    }

    private fun doSomethingInCycle() {
        for (i in 0 until 10) {
            Log.i("Number#", "$i")
        }
    }
}