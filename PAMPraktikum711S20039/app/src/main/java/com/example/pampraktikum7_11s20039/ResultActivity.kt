package com.example.pampraktikum7_11s20039

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var tvScore : TextView
    lateinit var btnPlayAgain : Button
    lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvScore = findViewById(R.id.tvScore)
        btnPlayAgain = findViewById(R.id.btnPlayAgain)
        btnExit = findViewById(R.id.btnExit)

        val score = intent.getIntExtra("userScore", 0)
        saveData(score)
        tvScore.text = "Score Kamu: ${score}"

        btnPlayAgain.setOnClickListener {
            val intent = Intent(
                this@ResultActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }

        btnExit.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }

    fun saveData(score : Int){
        val sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putInt("score", score)
        editor.apply()
    }

}
