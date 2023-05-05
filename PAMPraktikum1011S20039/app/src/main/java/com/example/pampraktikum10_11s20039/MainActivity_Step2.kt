//package com.example.pampraktikum10_11s20039
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import com.google.firebase.database.*
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var etNIM : EditText
//    lateinit var etName: EditText
//    lateinit var etAge : EditText
//    lateinit var btnSend : Button
//
//    lateinit var tvNIM : TextView
//    lateinit var tvName: TextView
//    lateinit var tvAge : TextView
//
//    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
//    val reference : DatabaseReference = database.reference.child("student")
//    val referenceGet : DatabaseReference = database.reference
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
//        tvNIM = findViewById(R.id.tvNIM)
//        tvName = findViewById(R.id.tvName)
//        tvAge = findViewById(R.id.tvAge)
//
//        referenceGet.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val nim : String = snapshot.child("student").child("nim").value as String
//                val name : String = snapshot.child("student").child("name").value as String
//                val age : Int = snapshot.child("student").child("age").getValue(Int::class.java) as Int
//
//                etNIM.setText(nim)
//                etName.setText(name)
//                etAge.setText(age.toString())
//
//                tvNIM.text = "NIM: ${nim}"
//                tvName.text = "Name: ${name}"
//                tvAge.text = "Age: ${age}"
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
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