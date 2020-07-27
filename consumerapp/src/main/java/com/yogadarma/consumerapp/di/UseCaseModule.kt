package com.yogadarma.consumerapp.di

import com.yogadarma.consumerapp.data.repositories.UserGithubRepository
import com.yogadarma.consumerapp.domain.usecases.*
import com.yogadarma.consumerapp.rx.SchedulerProvider
import org.koin.dsl.module

val useCaseModule = module {

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
        GetFavoriteByIdUseCase(
            get() as UserGithubRepository
        )
    }

    single {
        AddFavoriteUseCase(
            get() as UserGithubRepository
        )
    }

    single {
        DeleteFavoriteUseCase(
            get() as UserGithubRepository
        )
    }
}