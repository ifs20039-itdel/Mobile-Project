package com.example.pampraktikum7_11s20039

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvScore : TextView
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScore = findViewById(R.id.tvScore)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)

        retreiveData()

        btnAdd.setOnClickListener {
            val intent = Intent (
                this@MainActivity,
                GameActivity::class.java
            )
            intent.putExtra("operator", "+")
            startActivity(intent)
        }

        btnSub.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                GameActivity::class.java
            )
            intent.putExtra("operator", "-")
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        retreiveData()
    }

    fun retreiveData(){
        val sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        val dataScore = sharedPreferences.getInt("score", 0)
        tvScore.setText("${dataScore}")
    }
}