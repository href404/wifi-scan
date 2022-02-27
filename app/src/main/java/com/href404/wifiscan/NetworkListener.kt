package com.href404.wifiscan

import android.net.wifi.ScanResult

interface NetworkListener {
    fun onScanResult(networks: List<ScanResult>)
}