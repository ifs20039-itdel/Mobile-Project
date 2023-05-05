//package com.example.pampraktikum6_11s20038
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentTransaction
//
//class MainActivity : AppCompatActivity() {
//    lateinit var btnReplace : Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnReplace = findViewById(R.id.btnReplace)
//
//        val fragmentManager : FragmentManager = supportFragmentManager
//        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
//        val firstFragment = FirstFragment()
//        fragmentTransaction.add(R.id.flFragment, firstFragment)
//        fragmentTransaction.commit()
//
//
//
//        btnReplace.setOnClickListener {
//            val secondFragmentManager : FragmentManager = supportFragmentManager
//            val secondFragmentTransaction : FragmentTransaction = secondFragmentManager.beginTransaction()
//            val secondFragment = SecondFragment ()
//
//            secondFragmentTransaction.replace(R.id.flFragment,secondFragment)
//            secondFragmentTransaction.commit()
//        }
//
//
//    }
//}
//
