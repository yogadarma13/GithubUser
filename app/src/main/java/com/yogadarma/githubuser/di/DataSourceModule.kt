package com.yogadarma.githubuser.di

import android.content.Context
import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.data.db.dao.FavoriteDao
import com.yogadarma.githubuser.framework.datasourceimpl.UserGithubSourceImpl
import com.yogadarma.githubuser.framework.retrofit.NetworkApi
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        UserGithubSourceImpl(get() as NetworkApi, get() as Context) as UserGithubDataSource
    }
}