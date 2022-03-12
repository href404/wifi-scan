package com.href404.wifiscan

import android.content.Context
import android.net.wifi.ScanResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(
    private val networkService: NetworkService,
    private val applicationContext: Context
) : ViewModel(), NetworkListener {

    val networkCounter: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val ssid: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val frequency: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val level: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun onCreateView() {
        networkService.subscribe(this)

        networkCounter.value = applicationContext.getString(R.string.in_progress)
        ssid.value = applicationContext.getString(R.string.in_progress)
        frequency.value = applicationContext.getString(R.string.in_progress)
        level.value = applicationContext.getString(R.string.in_progress)
    }

    fun onDestroyView() {
        networkService.unsubscribe(this)
    }

    override fun onScanResult(networks: List<ScanResult>) {
        val network = networks.first()

        networkCounter.value = networks.size.toString()
        ssid.value = network.SSID
        frequency.value = network.frequency.toString()
        level.value = network.level.toString()
    }
}