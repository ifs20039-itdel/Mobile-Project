//package com.example.pampraktikum6_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentTransaction
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val fragmentManager : FragmentManager = supportFragmentManager
//        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
//
//        val firstFragment = FirstFragment()
//        fragmentTransaction.add(R.id.flFragment, firstFragment)
//        fragmentTransaction.commit()
//
//    }
//}