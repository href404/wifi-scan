package com.href404.wifiscan

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class WifiScanApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WifiScanApplication)
            modules(appModule)
        }
    }
}

val appModule = module {
    single<NetworkService> { NetworkServiceImpl() }
    viewModel { HomeViewModel(get(), get()) }
}