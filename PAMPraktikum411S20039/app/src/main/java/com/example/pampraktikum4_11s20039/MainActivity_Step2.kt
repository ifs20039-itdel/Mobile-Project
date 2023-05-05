//package com.example.pampraktikum4_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MainActivity : AppCompatActivity() {
//    lateinit var rvAsean : RecyclerView
//    var countryNameList = ArrayList<String>()
//    var countryDetailsList = ArrayList<String>()
//    var countryLogoList = ArrayList<Int>()
//
//    lateinit var adapter: CountriesAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        rvAsean = findViewById(R.id.rvAsean)
//        rvAsean.layoutManager = LinearLayoutManager (this@MainActivity)
//
//        countryNameList.addAll(
//            listOf("Brunei", "Filipina", "Indonesia", "Kamboja",
//                "Laos", "Malaysia", "Myanmar", "Singapura", "Thailand", "Vietnam")
//        )
//        countryDetailsList.addAll(
//            listOf("Ini adalah bendera Brunei", "Ini adalah bendera Filipina",
//                "Ini adalah bendera Indonesia", "Ini adalah bendera Kamboja", "Ini adalah bendera Laos",
//                "Ini adalah bendera Malaysia", "Ini adalah bendera Myanmar", "Ini adalah bendera Singapura",
//                "Ini adalah bendera Thailand", "Ini adalah bendera Vietnam")
//        )
//        countryLogoList.addAll(
//            listOf(R.drawable.brunei, R.drawable.filipina,
//                R.drawable.indonesia, R.drawable.kamboja,
//                R.drawable.laos, R.drawable.malaysia,
//                R.drawable.myanmar, R.drawable.singapura,
//                R.drawable.thailand, R.drawable.vietnam))
//
//        adapter = CountriesAdapter(
//            countryNameList,
//            countryDetailsList,
//            countryLogoList,
//            this@MainActivity
//        )
//        rvAsean.adapter = adapter
//    }
//}
