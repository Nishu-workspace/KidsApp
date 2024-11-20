package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import kotlin.random.Random

class SubstractionGame : AppCompatActivity() {
    lateinit var buttonBack : MaterialButton
    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTimer : TextView
    lateinit var editTextAnswer : EditText
    lateinit var buttonOk : Button
    lateinit var buttonNext : Button
    lateinit var textQuestion : TextView
    lateinit var gameOverCard: MaterialCardView
    lateinit var buttonGameOver : Button
    var correctAnswer = 0
    var userScore = 0
    var totalLife = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_substraction_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        gameOverCard = findViewById(R.id.gameOverCard)
        gameOverCard.setVisibility(View.GONE)
        buttonGameOver = findViewById(R.id.buttonGameOver)

        buttonBack = findViewById(R.id.buttonBack)
        textScore = findViewById(R.id.textViewScoreCount)
        textLife = findViewById(R.id.textViewLiveCount)

        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        textQuestion = findViewById(R.id.textViewQuestion)
        gameContinue()

        buttonBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonOk.setOnClickListener{

            val userInput = editTextAnswer.text.toString()
            if(userInput==""){
                Toast.makeText(applicationContext, "Please enter the answer or click on 'Next' Button", Toast.LENGTH_LONG).show()
            }
            else{
                if(userInput.toInt() == correctAnswer){
                    textQuestion.text = "Correct Answerrr!"
                    Toast.makeText(applicationContext,"Correct Answer!!!", Toast.LENGTH_LONG).show()
                    userScore = userScore + 10
                    textScore.text = userScore.toString()
                }
                else{
                    Toast.makeText(applicationContext, "Wrong Answer!!", Toast.LENGTH_LONG).show()
                    totalLife--
                    textLife.text = "$totalLife"
                    if(totalLife == 0){
                        gameOverCard.setVisibility(View.VISIBLE)
                        buttonGameOver.setOnClickListener{
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }

        buttonNext.setOnClickListener{
            gameContinue()
            editTextAnswer.setText("")
        }
    }
    fun gameContinue(){
        val number1 = Random.nextInt(0,100)
        var number2 = Random.nextInt(0,100)
        while(number1 == number2){
            number2 = Random.nextInt(0,100)
        }


        if (number1> number2) {
            textQuestion.text = "$number1 - $number2 = ?"
            correctAnswer = number1 - number2
        }
        else{
            textQuestion.text = "$number2 - $number1 = ?"
            correctAnswer = number2 - number1
        }
    }
}