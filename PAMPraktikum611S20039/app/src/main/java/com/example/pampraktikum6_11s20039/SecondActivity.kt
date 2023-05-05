package com.example.pampraktikum6_11s20039

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val position = intent.getIntExtra("position", 0)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val detailCountryFragment = DetailCountryFragment()

        val bundle = Bundle()
        bundle.putInt("position", position)
        detailCountryFragment.arguments = bundle

        fragmentTransaction.add(R.id.flFragment,
        detailCountryFragment)

        fragmentTransaction.commit()
    }
}