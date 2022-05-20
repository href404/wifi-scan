package com.href404.wifiscan.ui

import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.href404.wifiscan.R
import com.href404.wifiscan.WifiBroadcastReceveiver
import com.href404.wifiscan.services.NetworkService
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val networkService: NetworkService by inject()
    private val wifiReceiver = WifiBroadcastReceveiver(networkService)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        wifiManager.startScan()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiReceiver)
    }
}

