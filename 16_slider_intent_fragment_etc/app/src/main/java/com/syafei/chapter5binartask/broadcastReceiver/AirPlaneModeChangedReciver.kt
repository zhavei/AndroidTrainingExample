package com.syafei.chapter5binartask.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


/*
AirPlaneModeChangedReciver is and broadcast receiver that handle when airplanemode changed from user
 */
class AirPlaneModeChangedReciver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", true) ?: return

        if (isAirPlaneModeEnabled) {
            Toast.makeText(context, "Air Plane Mode Enabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Air Plane Mode Disabled", Toast.LENGTH_SHORT).show()
        }
    }
}