//package com.example.pampraktikum4_11s20039
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.pampraktikum4_11s20039.databinding.ActivityMainBinding
//
//class `MainActivity_Step13.kt` : AppCompatActivity() {
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.etName.setText("")
//        mainBinding.tvResult.setText("")
//
//        mainBinding.btnSubmit.setOnClickListener {
//            mainBinding.tvResult.text =
//                "Hay, ${mainBinding.etName.text.toString()}"
//            mainBinding.etName.setText("")
//        }
//    }
//}