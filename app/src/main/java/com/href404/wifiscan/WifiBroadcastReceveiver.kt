package com.href404.wifiscan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity

class WifiBroadcastReceveiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val wifiManager = context.applicationContext
            .getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager

        val networks = wifiManager.scanResults
        NetworkService.instance.notify(networks)
    }
}