package com.yogadarma.consumerapp.di

import com.yogadarma.consumerapp.framework.utils.DefaultSchedulerProvider
import com.yogadarma.consumerapp.rx.SchedulerProvider
import org.koin.dsl.module

val providerModule = module {
    single {
        DefaultSchedulerProvider() as SchedulerProvider
    }
}