package com.yogadarma.githubuser

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.yogadarma.githubuser.di.*
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
                viewModelModule,
                appDatabaseModule
            )
        }

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }
}