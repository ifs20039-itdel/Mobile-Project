//package com.example.pampraktikum4_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.TextView
//
//class MainActivity: AppCompatActivity() {
//    lateinit var btnStartClassicService: Button
//    lateinit var btnStartJobIntentService: Button
//    lateinit var btnStopService: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnStartClassicService = findViewById(R.id.btnStartClassicService)
//        btnStartJobIntentService = findViewById(R.id.btnStartJobIntentService)
//        btnStopService = findViewById(R.id.btnStopService)
//
//        btnStartClassicService.setOnClickListener {
//            val intent = Intent(this@MainActivity,
//                ClassicServiceExample::class.java)
//            startService(intent)
//        }
//        btnStartJobIntentService.setOnClickListener {
//            val intent = Intent(this@MainActivity,
//                JobIntentServiceExample::class.java)
//            JobIntentServiceExample.myBackGroundService(
//                this@MainActivity, intent
//            )
//        }
//
//        btnStopService.setOnClickListener {
//            val intent = Intent(this@MainActivity,
//                ClassicServiceExample::class.java)
//            stopService(intent)
//        }
//    }
//}
