package com.href404.wifiscan

import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.href404.wifiscan.databinding.MainActivityBinding

class MainActivity : AppCompatActivity(), NetworkListener {

    private lateinit var binding: MainActivityBinding
    private val networkService = NetworkService.instance
    private val wifiReceiver = WifiBroadcastReceveiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

        binding.networkCounter.text = networks.size.toString()
        binding.ssid.text = network.SSID
        binding.frequency.text = network.frequency.toString()
        binding.level.text = network.level.toString()
    }
}

