package com.href404.wifiscan

import androidx.test.platform.app.InstrumentationRegistry
import com.href404.wifiscan.services.NetworkServiceImpl
import org.junit.Assert
import org.junit.Test

class NetworkServiceTest {

    @Test
    fun whenScanIsStarted_shouldReturnTrue() {
        val networkService = NetworkServiceImpl()
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val result = networkService.scan(appContext)
        Assert.assertEquals(true, result)
    }
}