//package com.example.pampraktikum4_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.ListView
//import android.widget.Toast
//
//class MainActivity: AppCompatActivity() {
//    lateinit var lvAsean: ListView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        lvAsean = findViewById(R.id.lvAsean)
//
//        var aseanList = resources.getStringArray(R.array.asean)
//        var arrayAdapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            aseanList
//        )
//
//        lvAsean.adapter = arrayAdapter
//        lvAsean.setOnItemClickListener { parent, view, position,
//                                         id ->
//            val countryName: String = parent.getItemAtPosition(position).toString()
//            Toast.makeText(
//                applicationContext,
//                "Kamu memilih negara ${countryName}", Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//}
//
