package com.yogadarma.consumerapp

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.yogadarma.consumerapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                dataSourceModule,
                providerModule,
                repositoryModule,
                retrofitModule,
                useCaseModule,
                viewModelModule
            )
        }

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }
}