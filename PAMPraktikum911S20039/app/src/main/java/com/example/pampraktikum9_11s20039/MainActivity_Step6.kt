//package com.example.pampraktikum9_11s20039
//
//import android.app.AlarmManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.icu.util.Calendar
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.example.pampraktikum9_11s20039.databinding.ActivityMainBinding
//import com.google.android.material.timepicker.MaterialTimePicker
//import com.google.android.material.timepicker.TimeFormat
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var mainBinding: ActivityMainBinding
//
//    val calendar = Calendar.getInstance()
//    val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
//    val currentMinute = calendar.get(Calendar.MINUTE)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.btnSet.setOnClickListener {
//            if(ContextCompat.checkSelfPermission(
//                    this, android.Manifest.permission.POST_NOTIFICATIONS) !=
//                PackageManager.PERMISSION_GRANTED){
//
//                ActivityCompat.requestPermissions(
//                    this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 10)
//            }else{
//                showNotification()
//            }
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 10 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            showNotification()
//        }
//    }
//
//    fun showNotification(){
//
//        val timePicker = MaterialTimePicker.Builder()
//            .setTimeFormat(TimeFormat.CLOCK_12H)
//            .setHour(currentHour)
//            .setMinute(currentMinute)
//            .setTitleText("Belajar Membuat Repeated Notification")
//            .build()
//
//        timePicker.show(supportFragmentManager, "1")
//        timePicker.addOnPositiveButtonClickListener {
//            calendar.set(Calendar.HOUR_OF_DAY, timePicker.hour)
//            calendar.set(Calendar.MINUTE, timePicker.minute)
//            calendar.set(Calendar.SECOND, 0)
//            calendar.set(Calendar.MILLISECOND, 0)
//
//            val intent = Intent(
//                applicationContext, NotificationReceiver::class.java)
//
//            val pendingIntent = if(Build.VERSION.SDK_INT >= 23){
//                PendingIntent.getBroadcast(
//                    applicationContext, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//            }else{
//                PendingIntent.getBroadcast(applicationContext, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//            }
//            val alarmManager : AlarmManager =
//                getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//            alarmManager.setInexactRepeating(
//                AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
//                AlarmManager.INTERVAL_DAY,
//                pendingIntent
//            )
//
//            Toast.makeText(applicationContext,
//                "The alarm has been set", Toast.LENGTH_LONG).show()
//        }
//    }
//
//}
//
//
