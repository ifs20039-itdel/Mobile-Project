//package com.example.pampraktikum6_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.PersistableBundle
//import android.widget.Button
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity(){
//
//    lateinit var btnShowToast: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnShowToast = findViewById(R.id.btnShowToast)
//        btnShowToast.setOnClickListener {
//            Toast.makeText(
//                applicationContext,
//                R.string.toast_message,
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//}