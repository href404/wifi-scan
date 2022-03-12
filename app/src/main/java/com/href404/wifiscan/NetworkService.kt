package com.href404.wifiscan

import android.net.wifi.ScanResult

interface NetworkService {
    fun subscribe(listener: NetworkListener)
    fun unsubscribe(listener: NetworkListener)
    fun notify(networks: List<ScanResult>)
}

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
}