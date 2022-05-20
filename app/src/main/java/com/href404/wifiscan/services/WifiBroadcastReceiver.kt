package com.href404.wifiscan.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity

class WifiBroadcastReceiver(private val networkService: NetworkService) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val wifiManager = context.applicationContext
            .getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager

        networkService.notify(wifiManager.scanResults)
    }
}