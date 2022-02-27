package com.href404.wifiscan

import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), NetworkListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        NetworkService.instance.subscribe(this)

        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        val wifiReceiver = WifiBroadcastReceveiver(wifiManager)

        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        wifiManager.startScan()
    }

    override fun onScanResult(networks: List<ScanResult>) {
        findViewById<TextView>(R.id.networkCounter).text = getString(R.string.network_count, networks.size)
    }
}

