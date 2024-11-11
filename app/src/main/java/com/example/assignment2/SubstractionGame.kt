package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class SubstractionGame : AppCompatActivity() {
    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTimer : TextView
    lateinit var editTextAnswer : EditText
    lateinit var buttonOk : Button
    lateinit var buttonNext : Button
    lateinit var textQuestion : TextView
    lateinit var buttonBack : MaterialButton
    var correctAnswer = 0 // To store the correct Answer
    var userScore = 0  // To Store the user's score for session
    var totalLife = 3 // Total Life of user.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_substraction_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textScore = findViewById(R.id.textViewScoreCount)
        textLife = findViewById(R.id.textViewLiveCount)
        textTimer = findViewById(R.id.textViewTimeCount)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)
        buttonBack = findViewById(R.id.buttonBack)
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
        val number2 = Random.nextInt(0,100)
        if(number1>number2){
            textQuestion.text = "$number1 - $number2 = ?"
            correctAnswer = number1 - number2
        }
        else{
            textQuestion.text = "$number2 - $number1 = ?"
            correctAnswer = number2 - number1

        }

    }
}