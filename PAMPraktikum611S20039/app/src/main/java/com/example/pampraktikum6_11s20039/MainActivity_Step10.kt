//package com.example.pampraktikum6_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.fragment.app.FragmentManager
//
//class MainActivity : AppCompatActivity() {
//    lateinit var btnShow: Button
//    lateinit var tvName: TextView
//    lateinit var tvAge: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnShow = findViewById(R.id.btnShow)
//        tvName = findViewById(R.id.tvName)
//        tvAge = findViewById(R.id.tvAge)
//
//        btnShow.setOnClickListener {
//            val fragmentManager: FragmentManager = supportFragmentManager
//            val myDialogFragment: MyDialogFragment = MyDialogFragment()
//            myDialogFragment.isCancelable = false
//            myDialogFragment.show(fragmentManager, "MyDialogFragment")
//        }
//
//    }
//
//    fun getUserData(name: String, age: Int) {
//        tvName.text = "Name: ${name}"
//        tvAge.text = "Age: ${age}"
//
//    }
//}
//
//
