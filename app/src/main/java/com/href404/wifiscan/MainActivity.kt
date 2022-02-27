package com.href404.wifiscan

import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), NetworkListener {

    private val networkService = NetworkService.instance
    private val wifiReceiver = WifiBroadcastReceveiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        networkService.subscribe(this)
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))

        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        wifiManager.startScan()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiReceiver)
        networkService.unsubscribe(this)
    }

    override fun onScanResult(networks: List<ScanResult>) {
        val network = networks.first()

        findViewById<TextView>(R.id.network_counter).text = networks.size.toString()
        findViewById<TextView>(R.id.ssid).text = network.SSID
        findViewById<TextView>(R.id.frequency).text = network.frequency.toString()
        findViewById<TextView>(R.id.level).text = network.level.toString()
    }
}

