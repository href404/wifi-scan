package com.href404.wifiscan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager

class WifiBroadcastReceveiver(
    private val wifiManager: WifiManager
) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val networks = wifiManager.scanResults
        NetworkService.instance.notify(networks)
    }
}