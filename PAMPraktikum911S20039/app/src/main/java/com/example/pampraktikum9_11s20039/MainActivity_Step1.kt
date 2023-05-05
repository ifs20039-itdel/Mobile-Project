//package com.example.pampraktikum9_11s20039
//
//import android.content.pm.PackageManager
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Message
//import android.telephony.SmsManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var etMessage: EditText
//    lateinit var etPhone : EditText
//    lateinit var btnSend : Button
//
//    var userMessage : String = ""
//    var userPhone : String = ""
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etMessage = findViewById(R.id.etMessage)
//        etPhone = findViewById(R.id.etPhone)
//        btnSend = findViewById(R.id.btnSend)
//
//        btnSend.setOnClickListener{
//            userMessage = etMessage.text.toString()
//            userPhone = etPhone.text.toString()
//            sendSMS(userMessage, userPhone);
//        }
//    }
//
//    fun sendSMS(userMessage: String, userPhone: String){
//        if(ContextCompat.checkSelfPermission(this,
//                android.Manifest.permission.SEND_SMS)
//            != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,
//                arrayOf(android.Manifest.permission.SEND_SMS), 1            )
//        }else{
//            val smsManager : SmsManager
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
//                smsManager =
//                    this@MainActivity.getSystemService(SmsManager::class.java)
//            }else{
//                smsManager = SmsManager.getDefault();
//            }
//            smsManager.sendTextMessage(
//                userPhone, null, userMessage, null, null)
//
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(
//            requestCode, permissions, grantResults)
//        if(requestCode == 1 && grantResults.size > 0 &&
//            grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            val smsManager : SmsManager
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
//                smsManager =
//                    this@MainActivity.getSystemService(SmsManager::class.java)
//            }else{
//                smsManager = SmsManager.getDefault();
//            }
//
//            smsManager.sendTextMessage(
//                userPhone, null, userMessage, null, null)
//
//            Toast.makeText(
//                applicationContext, "Message Sent", Toast.LENGTH_LONG).show()
//        }
//    }
//}