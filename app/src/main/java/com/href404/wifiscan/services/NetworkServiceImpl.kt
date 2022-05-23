package com.href404.wifiscan.services

import android.content.Context
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity

class NetworkServiceImpl : NetworkService {

    private val listeners = mutableListOf<NetworkListener>()

    override fun subscribe(listener: NetworkListener) {
        listeners.add(listener)
    }

    override fun unsubscribe(listener: NetworkListener) {
        listeners.filter { it == listener }
    }

    override fun notify(networks: List<ScanResult>) {
        listeners.forEach { it.onScanResult(networks) }
    }

    override fun scan(applicationContext: Context): Boolean {
        val wifiManager = applicationContext.getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager
        return wifiManager.startScan()
    }
}