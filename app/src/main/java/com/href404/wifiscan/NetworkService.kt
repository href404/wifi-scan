package com.href404.wifiscan

import android.net.wifi.ScanResult

class NetworkService private constructor() {

    private val listeners = mutableListOf<NetworkListener>()

    fun subscribe(listener: NetworkListener) {
        listeners.add(listener)
    }

    fun unsubscribe(listener: NetworkListener) {
        listeners.filter { it == listener }
    }

    fun notify(networks: List<ScanResult>) {
        listeners.forEach { it.onScanResult(networks) }
    }

    companion object {
        val instance by lazy { NetworkService() }
    }
}