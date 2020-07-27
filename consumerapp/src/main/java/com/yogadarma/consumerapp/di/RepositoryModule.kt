package com.yogadarma.consumerapp.di

import com.yogadarma.consumerapp.data.datasource.UserGithubDataSource
import com.yogadarma.consumerapp.data.repositories.UserGithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        UserGithubRepository(
            get() as UserGithubDataSource
        )
    }
}