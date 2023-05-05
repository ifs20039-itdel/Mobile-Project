package com.example.pampraktikum9_11s20039

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver : BroadcastReceiver(){

    private val CHANNEL_ID = "1"

    override fun onReceive(context: Context?, intent: Intent?) {

        if (context == null) return

        val builder = NotificationCompat.Builder(
            context, CHANNEL_ID)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANNEL_ID, "1", NotificationManager.IMPORTANCE_HIGH)
            val manager : NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as
                        NotificationManager
            manager.createNotificationChannel(channel)

            builder.setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Belajar Notifikasi Android")
                .setContentText(
                    "Sekarang adalah waktu sesuai pengaturan kamu.")
        }else{
            builder.setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Belajar Notifikasi Android")
                .setContentText(
                    "Sekarang adalah waktu sesuai pengaturan kamu.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
        }

        val notificationManagerCompat =
            NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(1, builder.build())
    }
}