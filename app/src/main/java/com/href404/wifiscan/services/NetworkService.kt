package com.href404.wifiscan.services

import android.content.Context
import android.net.wifi.ScanResult

interface NetworkService {
    fun subscribe(listener: NetworkListener)
    fun unsubscribe(listener: NetworkListener)
    fun isSubscribe(listener: NetworkListener): Boolean
    fun notify(networks: List<ScanResult>)
    fun scan(applicationContext: Context): Boolean
}