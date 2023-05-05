//package com.example.pampraktikum10_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class MainActivity : AppCompatActivity() {
//    lateinit var etNIM : EditText
//    lateinit var etName: EditText
//    lateinit var etAge : EditText
//    lateinit var btnSend : Button
//
//    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
//    val reference : DatabaseReference =
//        database.reference.child("student")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etNIM = findViewById(R.id.etNIM)
//        etName = findViewById(R.id.etName)
//        etAge = findViewById(R.id.etAge)
//        btnSend = findViewById(R.id.btnSend)
//
//        btnSend.setOnClickListener {
//            val nim : String = etNIM.text.toString()
//            val name : String = etName.text.toString()
//            val age : Int = etAge.text.toString().toInt()
//
//            reference.child("nim").setValue(nim)
//            reference.child("name").setValue(name)
//            reference.child("age").setValue(age)
//        }
//    }
//}