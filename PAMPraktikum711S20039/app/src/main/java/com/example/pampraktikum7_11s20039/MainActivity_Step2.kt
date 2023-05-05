//package com.example.pampraktikum7_11s20039
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var btnAdd: Button
//    lateinit var btnSub: Button
//    lateinit var btnMul: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnAdd = findViewById(R.id.btnAdd)
//        btnSub = findViewById(R.id.btnSub)
//        btnMul = findViewById(R.id.btnMul)
//
//        btnAdd.setOnClickListener {
//            val intent = Intent(
//                this@`MainActivity_Step2.kt`,
//                GameActivity::class.java
//            )
//            intent.putExtra("operator", "+")
//            startActivity(intent)
//        }
//
//        btnSub.setOnClickListener {
//            val intent = Intent(
//                this@`MainActivity_Step2.kt`,
//                GameActivity::class.java
//            )
//            intent.putExtra("operator", "-")
//            startActivity(intent)
//        }
//
//        btnMul.setOnClickListener {
//            val intent = Intent(
//                this@`MainActivity_Step2.kt`,
//                GameActivity::class.java
//            )
//            intent.putExtra("operator", "*")
//            startActivity(intent)
//        }
//
//    }
//}
