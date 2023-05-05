//package com.example.pampraktikum9_11s20039
//
//import android.content.Intent
//import android.location.Address
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Message
//import android.widget.Button
//import android.widget.EditText
//import javax.security.auth.Subject
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var etMail: EditText
//    lateinit var etSubject: EditText
//    lateinit var etMessage: EditText
//    lateinit var btnSend: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etMail = findViewById(R.id.etEmail)
//        etSubject = findViewById(R.id.etSubject)
//        etMessage = findViewById(R.id.etMessage)
//        btnSend = findViewById(R.id.btnSend)
//
//        btnSend.setOnClickListener {
//            val userAddress = etMail.text.toString()
//            val userSubject = etSubject.text.toString()
//            val userMessage = etMessage.text.toString()
//
//            sendEmail(userAddress, userSubject, userMessage)
//        }
//    }
//
//    fun sendEmail(
//        userAddress : String, userSubject: String, userMessage: String){
//        val emailAddress = arrayOf(userAddress)
//        val emailIntent = Intent(Intent.ACTION_SENDTO)
//        emailIntent.data = Uri.parse("mailto: ")
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, userSubject)
//        emailIntent.putExtra(Intent.EXTRA_TEXT, userMessage)
//
//        if(emailIntent.resolveActivity(packageManager) != null){
//            startActivity(
//                Intent.createChooser(emailIntent, "Choose an app"))
//        }
//    }
//}