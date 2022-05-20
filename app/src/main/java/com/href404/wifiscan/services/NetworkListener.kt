package com.href404.wifiscan.services

import android.net.wifi.ScanResult

interface NetworkListener {
    fun onScanResult(networks: List<ScanResult>)
}