package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.framework.datasourceimpl.UserGithubSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        UserGithubSourceImpl(get()) as UserGithubDataSource
    }
}