package com.example.pampraktikum9_11s20039

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReceiverDismiss : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val messageText = intent?.getStringExtra("Toast")

        Toast.makeText(
            context,
            messageText,
            Toast.LENGTH_LONG
        ).show()
    }
}