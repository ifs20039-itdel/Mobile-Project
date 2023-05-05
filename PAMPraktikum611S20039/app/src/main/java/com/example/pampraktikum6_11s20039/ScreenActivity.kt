package com.example.pampraktikum6_11s20039

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScreenActivity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getLongExtra("phone", 0)

        tvName.text = "Hello ${name}"
        tvEmail.text = "Email: ${email}"
        tvPhone.text = "Phone Number: ${phone}"
    }
}