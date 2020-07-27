package com.yogadarma.consumerapp.di

import android.content.Context
import com.yogadarma.consumerapp.data.datasource.UserGithubDataSource
import com.yogadarma.consumerapp.framework.datasourceimpl.UserGithubSourceImpl
import com.yogadarma.consumerapp.framework.retrofit.NetworkApi
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        UserGithubSourceImpl(get() as NetworkApi, get() as Context) as UserGithubDataSource
    }
}