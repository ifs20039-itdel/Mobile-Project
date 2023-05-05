//package com.example.pampraktikum6_11s20039
//
//import android.content.Context
//import android.content.SharedPreferences
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.CheckBox
//import android.widget.EditText
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//    lateinit var etName: EditText
//    lateinit var etMessage: EditText
//    lateinit var btnCounter: Button
//    lateinit var cbRemember: CheckBox
//
//    var count = 0
//
//    var dataMessage: String? = null
//    var dataName: String? = null
//    var dataRemember: Boolean? = null
//
//    lateinit var sharedPreferences: SharedPreferences
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etName = findViewById(R.id.etName)
//        etMessage = findViewById(R.id.etMessage)
//        btnCounter = findViewById(R.id.btnCounter)
//        cbRemember = findViewById(R.id.cbRemember)
//
//        btnCounter.setOnClickListener {
//            count += 1
//            btnCounter.setText("${count}")
//        }
//    }
//
//    override fun onPause() {
//        super.onPause()
//        saveData()
//    }
//
//    fun saveData() {
//        sharedPreferences = this.getSharedPreferences(
//            "saveData", Context.MODE_PRIVATE
//        )
//
//        dataName = etName.text.toString()
//        dataMessage = etMessage.text.toString()
//        dataRemember = cbRemember.isChecked
//
//        val editor = sharedPreferences.edit()
//        editor.putString("data-name", dataName)
//        editor.putString("data-message", dataMessage)
//        editor.putInt("data-count", count)
//        editor.putBoolean("data-remember", dataRemember!!)
//        editor.apply()
//
//        Toast.makeText(
//            applicationContext,
//            "Your data is saved",
//            Toast.LENGTH_LONG
//        ).show()
//    }
//}
//
//
