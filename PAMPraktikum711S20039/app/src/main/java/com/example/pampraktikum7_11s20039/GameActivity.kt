package com.example.pampraktikum7_11s20039

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import java.util.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var tvScore : TextView
    lateinit var tvLife : TextView
    lateinit var tvTime : TextView
    lateinit var tvQuestion : TextView
    lateinit var etAnswer : EditText
    lateinit var btnAnswer : Button
    lateinit var btnNext : Button

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3
    var gameOperator = "+"
    var isGameOver = false

    lateinit var gameTimer: CountDownTimer
    private val startTimerInMiles : Long = 20000
    var timeLeftInMiles : Long = startTimerInMiles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val operator = intent.getStringExtra("operator")
        when (operator){
            "+" -> {
                gameOperator = "+"
                supportActionBar!!.title = "Penjumlahan"
            }
            "-" -> {
                gameOperator = "-"
                supportActionBar!!.title = "Pengurangan"
            }
            "*" -> {
                gameOperator = "*"
                supportActionBar!!.title = "Perkalian"
            }
        }

        tvScore = findViewById(R.id.tvScore)
        tvLife = findViewById(R.id.tvLife)
        tvTime = findViewById(R.id.tvTime)
        tvQuestion = findViewById(R.id.tvQuestion)
        etAnswer = findViewById(R.id.etAnswer)
        btnAnswer = findViewById(R.id.btnAnswer)
        btnNext = findViewById(R.id.btnNext)

        gameContinue()

        btnAnswer.setOnClickListener {
            val answer = etAnswer.text.toString()
            if (answer == ""){
                Toast.makeText(
                    applicationContext,
                    "Tolong berikan jawaban atau klik tombol selanjutnya",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                pauseTimer()
                resetTimer()
                updateText()

                val userAnswer = answer.toInt()
                if(userAnswer == correctAnswer){
                    userScore += 1
                    tvQuestion.text = "Selamat, jawaban kamu benar"
                    tvScore.text = userScore.toString()
                }else{
                    userLife -= 1
                    tvQuestion.text = "Maaf, jawaban kamu salah"
                    tvLife.text = userLife.toString()
                }
                btnAnswer.visibility = View.INVISIBLE
            }
        }

        btnNext.setOnClickListener {
            pauseTimer()
            resetTimer()
            etAnswer.setText("")
            btnAnswer.isVisible = true

            if (userLife == 0){
                Toast.makeText(
                    applicationContext,
                    "Permainan Berakhir",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(
                    this@GameActivity,
                    ResultActivity::class.java
                )
                intent.putExtra("userScore", userScore)
                startActivity(intent)
                finish()
            }else{
                gameContinue()
                btnAnswer.visibility = View.VISIBLE
            }
        }
    }

    fun gameContinue()
    {
        val number1 = Random.nextInt(0, 100)
        val number2 = Random.nextInt(0, 100)

        when(gameOperator){
            "+" -> {
                tvQuestion.text = "${number1} + ${number2}"
                correctAnswer = number1 + number2
            }
            "-" -> {
                tvQuestion.text = "${number1} - ${number2}"
                correctAnswer = number1 - number2
            }
            "*" -> {
                tvQuestion.text = "${number1} * ${number2}"
                correctAnswer = number1 * number2
            }
        }

        startTimer()
    }

    fun startTimer(){
        gameTimer = object : CountDownTimer(timeLeftInMiles, 1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMiles = millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()

                userLife -= 1
                tvLife.text = userLife.toString()
                tvQuestion.text = "Maaf, waktu telah habis"
                btnAnswer.isVisible = false
            }

        }.start()
    }

    fun updateText(){
        val remainingTime : Int = (timeLeftInMiles / 1000).toInt()
        tvTime.text = String.format(Locale.getDefault(), "%02d", remainingTime)
    }

    fun resetTimer(){
        gameTimer.cancel()
    }

    fun pauseTimer(){
        timeLeftInMiles = startTimerInMiles
        updateText()
    }

}