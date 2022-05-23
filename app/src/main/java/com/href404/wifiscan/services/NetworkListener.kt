package com.href404.wifiscan.services

import android.net.wifi.ScanResult

fun interface NetworkListener {
    fun onScanResult(networks: List<ScanResult>)
}