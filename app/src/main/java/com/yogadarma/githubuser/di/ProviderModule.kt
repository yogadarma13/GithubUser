package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.framework.utils.DefaultSchedulerProvider
import com.yogadarma.githubuser.rx.SchedulerProvider
import org.koin.dsl.module

val providerModule = module {
    single {
        DefaultSchedulerProvider() as SchedulerProvider
    }
}