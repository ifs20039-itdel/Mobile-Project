//package com.example.pampraktikum9_11s20039
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.content.pm.PackageManager
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.core.app.ActivityCompat
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import androidx.core.content.ContextCompat
//import com.example.pampraktikum9_11s20039.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private val CHANNEL_ID = "1"
//
//    lateinit var mainBinding: ActivityMainBinding
//    var counter = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        mainBinding.btnSend.setOnClickListener {
//            counter++;
//            mainBinding.btnSend.text = counter.toString()
//            if(counter % 5 == 0){
//                if(ContextCompat.checkSelfPermission(
//                        this, android.Manifest.permission.POST_NOTIFICATIONS) !=
//                    PackageManager.PERMISSION_GRANTED){
//
//                    ActivityCompat.requestPermissions(
//                        this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 10)
//                }else{
//                    startNotification()
//                }
//            }
//        }
//    }
//    fun startNotification(){
//
//        val builder = NotificationCompat.Builder(this@MainActivity, CHANNEL_ID)
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            val channel = NotificationChannel(CHANNEL_ID, "1",
//                NotificationManager.IMPORTANCE_DEFAULT)
//            val manager : NotificationManager =
//                getSystemService(Context.NOTIFICATION_SERVICE) as
//                        NotificationManager
//            manager.createNotificationChannel(channel)
//
//            builder.setSmallIcon(R.drawable.small_icon)
//                .setContentTitle("Belajar Notifikasi Android")
//                .setContentText(
//                    "Kamu telah menekan tombol sebanyak ${counter}")
//        }else{
//            builder.setSmallIcon(R.drawable.small_icon)
//                .setContentTitle("Belajar Notifikasi Android")
//                .setContentText(
//                    "Kamu telah menekan tombol sebanyak ${counter}")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//        }
//
//        val notificationManagerCompat = NotificationManagerCompat.from(this@MainActivity)
//        notificationManagerCompat.notify(1, builder.build())
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 10 && grantResults[0] ==
//            PackageManager.PERMISSION_GRANTED){
//            startNotification()
//        }
//    }
//}