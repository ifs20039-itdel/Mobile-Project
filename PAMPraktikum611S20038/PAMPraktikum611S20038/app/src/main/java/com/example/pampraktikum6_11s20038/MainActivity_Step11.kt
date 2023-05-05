//package com.example.pampraktikum6_11s20038
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import com.google.android.material.textfield.TextInputEditText
//
//class MainActivity : AppCompatActivity() {
//    lateinit var etName: TextInputEditText
//    lateinit var etEmail: TextInputEditText
//    lateinit var etPhone: TextInputEditText
//    lateinit var btnSignUp: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etName = findViewById(R.id.etName)
//        etEmail = findViewById(R.id.etEmail)
//        etPhone = findViewById(R.id.etPhone)
//        btnSignUp = findViewById(R.id.btnSignUp)
//
//        btnSignUp.setOnClickListener {
//            val name = etName.text.toString()
//            val email = etEmail.text.toString()
//            val phone = etPhone.text.toString().toLong()
//
//            val intent = Intent(this, ScreenActivity::class.java)
//            intent.putExtra("name", name)
//            intent.putExtra("email", email)
//            intent.putExtra("phone", phone)
//
//            startActivity(intent)
//        }
//    }
//}
//
//
//
//
//
