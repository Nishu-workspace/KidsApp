package com.example.assignment2

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.assignment2.databinding.ActivityCatchFruitBinding
import kotlin.random.Random

class CatchFruit : AppCompatActivity() {
    lateinit var binding: ActivityCatchFruitBinding


    var score = 0
    val imageArray = ArrayList<ImageView>()
    val handler = android.os.Handler(Looper.getMainLooper())
    lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCatchFruitBinding>(this,R.layout.activity_catch_fruit)
        binding.catchFruits = this
        binding.score =  getString(R.string.score_0)

        score = 0
        imageArray.addAll(
            listOf(
                binding.fruit1,binding.fruit2,
                binding.fruit4,binding.fruit5,binding.fruit6


            )
        )
        hideImages()
        playAndRestart()

        imageArray.forEach { imageView ->
            imageView.setOnClickListener {
                if (imageView.visibility == View.VISIBLE) {
                    increaseScore()
                    imageView.visibility = View.INVISIBLE // Hide the clicked fruit
                }
            }
        }
        }
    fun hideImages(){
        runnable = Runnable{
            imageArray.forEach{ it.visibility = View.INVISIBLE}
            imageArray[Random.nextInt(5)].visibility = View.VISIBLE
            handler.postDelayed(runnable, 1000)
        }
        handler.post(runnable) }
    fun increaseScore(){
        score++
        binding.score = "Score : $score"
    }
    fun playAndRestart(){
        score = 0
        binding.score =  "Score :  0"
        hideImages()
        binding.time = "Time: 20"
        imageArray.forEach{ it.visibility = View.INVISIBLE}

        object : CountDownTimer(20000,1000){
            override fun onFinish() {
                binding.time = getString(R.string.time_up)
                handler.removeCallbacks(runnable)

                AlertDialog.Builder(this@CatchFruit).apply{
                    setCancelable(false)
                    setTitle(getString(R.string.game_name))
                    setMessage("Your Score: $score\nWould you like to play again?")
                    setPositiveButton(getString(R.string.yes)){_,_ -> playAndRestart()}
                    setNegativeButton(getString(R.string.no)){_,_ ->
                        score  = 0
                        binding.score = "Score : 0"
                        binding.time = "Time :  0"
                        imageArray.forEach { it.visibility = View.INVISIBLE}
                        finish()
                    }

                }.create().show()
            }

            override fun onTick(tick: Long) {
                binding.time = "Time :" + tick/1000
            }
        }.start()

    }
    }





