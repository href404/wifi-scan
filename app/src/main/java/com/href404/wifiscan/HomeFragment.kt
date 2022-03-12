package com.href404.wifiscan

import android.net.wifi.ScanResult
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.href404.wifiscan.databinding.HomeFragmentBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), NetworkListener {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    private val networkService: NetworkService by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        networkService.subscribe(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        networkService.unsubscribe(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onScanResult(networks: List<ScanResult>) {
        val network = networks.first()

        binding.networkCounter.text = networks.size.toString()
        binding.ssid.text = network.SSID
        binding.frequency.text = network.frequency.toString()
        binding.level.text = network.level.toString()
    }

}