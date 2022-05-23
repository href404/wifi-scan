package com.href404.wifiscan.services

import org.junit.Assert
import org.junit.Test

class NetworkServiceImplTest {

    @Test
    fun subscribe_shouldAddListener() {
        val networkListener = NetworkListener {
            Assert.assertEquals(0, it.size)
        }

        val networkService = NetworkServiceImpl()
        networkService.subscribe(networkListener)

        Assert.assertEquals(true, networkService.isSubscribe(networkListener))
    }

    @Test
    fun whenSubscribe_shouldCallListener() {
        var isListenerCalled = false
        val networkService = NetworkServiceImpl()
        networkService.subscribe {
            isListenerCalled = true
            Assert.assertEquals(0, it.size)
        }

        networkService.notify(listOf())
        Assert.assertEquals(true, isListenerCalled)
    }

    @Test
    fun whenSubscribeAndUnsubscribe_shouldNotCallListener() {
        var isListenerCalled = false
        val networkListener = NetworkListener {
            isListenerCalled = true
            Assert.assertEquals(0, it.size)
        }

        val networkService = NetworkServiceImpl()
        networkService.subscribe(networkListener)
        networkService.unsubscribe(networkListener)
        networkService.notify(listOf())

        Assert.assertEquals(false, isListenerCalled)
    }
}