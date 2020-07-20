package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.usecases.*
import com.yogadarma.githubuser.rx.SchedulerProvider
import org.koin.dsl.module

val useCaseModule = module {

    single {
        SearchUserUseCase(
            get() as UserGithubRepository,
            get() as SchedulerProvider
        )
    }

    single {
        GetDetailUserUseCase(
            get() as UserGithubRepository,
            get() as SchedulerProvider
        )
    }

    single {
        GetFollowerUserUseCase(
            get() as UserGithubRepository,
            get() as SchedulerProvider
        )
    }

    single {
        GetFollowingUserUseCase(
            get() as UserGithubRepository,
            get() as SchedulerProvider
        )
    }

    single {
        GetFavoriteUseCase(
            get() as UserGithubRepository
        )
    }

    single {
        AddFavoriteUseCase(
            get() as UserGithubRepository
        )
    }
}