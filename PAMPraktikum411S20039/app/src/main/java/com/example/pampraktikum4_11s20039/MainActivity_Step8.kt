//package com.example.pampraktikum4_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.TextView
//
//
//class MainActivity: AppCompatActivity() {
//
//    lateinit var tvCounter : TextView
//    lateinit var btnAdd : Button
//    lateinit var btnNextActivity: Button
//
//    var counter = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        tvCounter = findViewById(R.id.tvCounter)
//        btnAdd = findViewById(R.id.btnAdd)
//        btnNextActivity = findViewById(R.id.btnNextActivity)
//
//        btnAdd.setOnClickListener {
//            counter += 1
//            tvCounter.text = "${counter}"
//        }
//
//        btnNextActivity.setOnClickListener {
//            var intent = Intent(this@MainActivity, SecondActivity::class.java)
//            startActivity(intent)
//        }
//
//        Log.d("Message", "Main Activity onCreate")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("Message", "Main Activity onDestroy")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("Message", "Main Activity onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("Message", "Main Activity onStop")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("Message", "Main Activity onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("Message", "Main Activity onResume")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("Message", "Main Activity onRestart")
//    }
//}
