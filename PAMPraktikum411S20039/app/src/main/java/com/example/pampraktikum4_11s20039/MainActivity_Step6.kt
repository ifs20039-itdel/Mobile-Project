//package com.example.pampraktikum4_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//
//class MainActivity: AppCompatActivity() {
//
//    lateinit var etName: EditText
//    lateinit var etAge: EditText
//    lateinit var btnSubmit : Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etName = findViewById(R.id.etName)
//        etAge = findViewById(R.id.etAge)
//        btnSubmit= findViewById(R.id.btnSubmit)
//
//        btnSubmit.setOnClickListener {
//            var name: String = etName.text.toString()
//            var age: Int = etAge.text.toString().toInt()
//            var intent = Intent(
//                this@MainActivity, SecondActivity::class.java)
//
//            intent.putExtra("name", name)
//            intent.putExtra("age", age)
//            startActivity(intent)
//        }
//    }
//}
