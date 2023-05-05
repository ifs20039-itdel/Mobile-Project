//package com.example.pampraktikum10_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.PersistableBundle
//import com.example.pampraktikum10_11s20039.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.fabAdd.setOnClickListener{
//            val intent = Intent(
//                this,
//                AddUserActivity::class.java
//            )
//            startActivity(intent)
//        }
//    }
//
//}