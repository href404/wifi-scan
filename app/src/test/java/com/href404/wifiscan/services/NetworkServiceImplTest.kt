package com.href404.wifiscan.services

import android.net.wifi.ScanResult
import org.junit.Assert
import org.junit.Test

class NetworkServiceImplTest {

    @Test
    fun whenSubscribe_shouldCallListener() {
        var isListenerCalled = false
        val networkListener = object : NetworkListener {
            override fun onScanResult(networks: List<ScanResult>) {
                isListenerCalled = true
            }
        }

        val networkService = NetworkServiceImpl()
        networkService.subscribe(networkListener)
        networkService.notify(listOf())

        Assert.assertEquals(true, isListenerCalled)
    }

    @Test
    fun whenSubscribeAndUnsubscribe_shouldNotCallListener() {
        var isListenerCalled = false
        val networkListener = object : NetworkListener {
            override fun onScanResult(networks: List<ScanResult>) {
                isListenerCalled = true
            }
        }

        val networkService = NetworkServiceImpl()
        networkService.subscribe(networkListener)
        networkService.unsubscribe(networkListener)
        networkService.notify(listOf())

        Assert.assertEquals(false, isListenerCalled)
    }
}