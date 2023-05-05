//package com.example.pampraktikum4_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.GridView
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var gvAnimal: GridView
//    var nameAnimalList = ArrayList<String>()
//    var imageAnimalList = ArrayList<Int>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        gvAnimal = findViewById(R.id.gvAnimal)
//        fillArrays()
//
//        val adapter = AnimalsAdapter(this, nameAnimalList, imageAnimalList)
//        gvAnimal.adapter = adapter
//
//        gvAnimal.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(
//                applicationContext,
//                "Kamu memilih hewan ${nameAnimalList[position]}.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//    fun fillArrays() {
//        nameAnimalList.addAll(listOf(
//            "Elephant", "Giraffe", "Gorilla", "Hippo", "Lion",
//            "Panda", "Rabbit", "Rhino", "Zebra"
//        ))
//        imageAnimalList.addAll(listOf(
//            R.drawable.elephant, R.drawable.giraffe,
//            R.drawable.gorilla, R.drawable.hippo, R.drawable.lion, R.drawable.panda, R.drawable.rabbit, R.drawable.rhino, R.drawable.zebra
//        ))
//    }
//}
