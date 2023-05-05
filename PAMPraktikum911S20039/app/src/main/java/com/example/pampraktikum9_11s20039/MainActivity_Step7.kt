//package com.example.pampraktikum9_11s20039
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
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
//        val intent = Intent(
//            applicationContext, MainActivity::class.java)
//
//        val pendingIntent = if(Build.VERSION.SDK_INT >= 23){
//            PendingIntent.getActivity(applicationContext, 0,
//                intent,PendingIntent.FLAG_UPDATE_CURRENT or
//                        PendingIntent.FLAG_IMMUTABLE)
//        }else{
//            PendingIntent.getActivity(applicationContext, 0,
//                intent, PendingIntent.FLAG_UPDATE_CURRENT)
//        }
//        //action button
//        val actionIntent = Intent(applicationContext, Receiver::class.java)
//        actionIntent.putExtra("toast", "Ini adalah pesan notifikasi.")
//
//        val actionPending = if(Build.VERSION.SDK_INT >= 23){
//            PendingIntent.getBroadcast(applicationContext, 1,
//                actionIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//        }else{
//            PendingIntent.getBroadcast(applicationContext, 1, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//        }
//
//        val dismissIntent =
//            Intent(applicationContext, ReceiverDismiss::class.java)
//
//        val dismissPending = if(Build.VERSION.SDK_INT >= 23){
//            PendingIntent.getBroadcast(applicationContext, 2,
//                dismissIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//        }else{
//            PendingIntent.getBroadcast(applicationContext, 2,
//                dismissIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//        }
//
//        val icon : Bitmap =
//            BitmapFactory.decodeResource(resources, R.drawable.android)
//        val text : String = resources.getString(R.string.big_text)
//
//        val builder =
//            NotificationCompat.Builder(this@MainActivity, CHANNEL_ID)
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            val channel = NotificationChannel(
//                CHANNEL_ID, "1", NotificationManager.IMPORTANCE_DEFAULT)
//            val manager : NotificationManager =
//                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            manager.createNotificationChannel(channel)
//
//
//            builder.setSmallIcon(R.drawable.small_icon)
//                .setContentTitle("Belajar Notifikasi Android")
//                .setContentText(
//                    "Kamu telah menekan tombol sebanyak ${counter}")
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .addAction(
//                    R.drawable.small_icon, "Show Toast", actionPending)
//                .addAction(R.drawable.small_icon, "Dismiss", dismissPending)
//                .setLargeIcon(icon)
//                .setStyle(NotificationCompat.BigTextStyle().bigText(text))
//        }else{
//            builder.setSmallIcon(R.drawable.small_icon)
//                .setContentTitle("Belajar Notifikasi Android")
//                .setContentText(
//                    "Kamu telah menekan tombol sebanyak ${counter}")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .addAction(
//                    R.drawable.small_icon, "Show Toast", actionPending)
//                .addAction(R.drawable.small_icon, "Dismiss", dismissPending)
//                .setLargeIcon(icon)
//                .setStyle(NotificationCompat.BigTextStyle().bigText(text))
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