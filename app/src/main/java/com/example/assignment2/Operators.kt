package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import kotlin.random.Random

class Operators : AppCompatActivity() {
    lateinit var additionGame: MaterialCardView
    lateinit var multiplicatinGame: MaterialCardView
    lateinit var subGame: MaterialCardView
    lateinit var divGame : MaterialCardView
    lateinit var randomGame: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operators)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        additionGame = findViewById<MaterialCardView>(R.id.additionGame)
        additionGame.setOnClickListener{
            val intent  =  Intent(this, AdditionGame::class.java)
            startActivity(intent)
        }
        multiplicatinGame = findViewById(R.id.multiplyGame)
        multiplicatinGame.setOnClickListener{
            val intent = Intent(this, multiplyGame::class.java)
            startActivity(intent)
        }
        subGame = findViewById(R.id.substractionGame)
        subGame.setOnClickListener{
            val intent = Intent(this, SubstractionGame::class.java)
            startActivity(intent)
        }
        divGame = findViewById(R.id.divisionGame)
        divGame.setOnClickListener{
            val intent = Intent(this, divisionGame::class.java)
            startActivity(intent)
        }
        randomGame = findViewById(R.id.randomGame)
        randomGame.setOnClickListener{
            val x = Random.nextInt(1,5)
            when(x){
                1 -> {val intent = Intent(this, AdditionGame::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, SubstractionGame::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this, multiplyGame::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this, divisionGame::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}