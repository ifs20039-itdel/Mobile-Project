package com.example.pampraktikum4_11s20039

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastExample : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneMode: Boolean =
            intent!!.getBooleanExtra("state", false)
        if (isAirPlaneMode) {
            Toast.makeText(
                context, "Saat ini, perangkat dalam mode pesawat.",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                context,
                "Saat ini, perangkat tidak dalam mode pesawat.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}
