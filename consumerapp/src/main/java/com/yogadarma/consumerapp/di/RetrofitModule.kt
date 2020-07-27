package com.yogadarma.consumerapp.di

import com.yogadarma.consumerapp.framework.retrofit.NetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {
    single {
        NetworkClient.provideRetrofit(get()) as Retrofit
    }

    single {
        NetworkClient.provideNetworkApi(get())
    }
}