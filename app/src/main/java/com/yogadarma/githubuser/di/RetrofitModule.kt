package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.framework.retrofit.NetworkClient
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