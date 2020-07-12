package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        UserGithubRepository(
            get() as UserGithubDataSource
        )
    }
}