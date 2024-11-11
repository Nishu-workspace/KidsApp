package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    lateinit var operatorsGame : MaterialCardView
    lateinit var catchTheFruit : MaterialCardView
    lateinit var drawButton : MaterialCardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        operatorsGame = findViewById(R.id.operators)
        operatorsGame.setOnClickListener{
            val intent = Intent(this, Operators::class.java)
            startActivity(intent)
        }
        catchTheFruit = findViewById(R.id.catchTheFruits)
        catchTheFruit.setOnClickListener{
            val  intent = Intent(this, CatchFruit::class.java)
            startActivity(intent)
        }
        drawButton = findViewById(R.id.drawButton)
        drawButton.setOnClickListener{
            val intent = Intent(this, DrawCanvas::class.java)
            startActivity(intent)
        }
    }

}