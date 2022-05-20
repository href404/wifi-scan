package com.href404.wifiscan.services

import android.net.wifi.ScanResult

interface NetworkService {
    fun subscribe(listener: NetworkListener)
    fun unsubscribe(listener: NetworkListener)
    fun notify(networks: List<ScanResult>)
}