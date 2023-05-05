//package com.example.pampraktikum6_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.TextView
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentTransaction
//
//
//class MainActivity : AppCompatActivity() {
//    lateinit var tvName : TextView
//    lateinit var tvEmail: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        tvName = findViewById(R.id.tvName)
//        tvEmail = findViewById(R.id.tvEmail)
//
//        val fragmentManager: FragmentManager = supportFragmentManager
//        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//        val myFragment = MyFragment()
//        fragmentTransaction.add(R.id.flFragment, myFragment)
//        fragmentTransaction.commit()
//    }
//
//    fun takeData(name: String, email : String) {
//        tvName.text = name
//        tvEmail.text = email
//    }
//
//}
//
//
