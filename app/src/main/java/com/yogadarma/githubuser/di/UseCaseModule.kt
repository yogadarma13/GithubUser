package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.usecases.GetDetailUserUseCase
import com.yogadarma.githubuser.domain.usecases.GetFollowerUserUseCase
import com.yogadarma.githubuser.domain.usecases.GetFollowingUserUseCase
import com.yogadarma.githubuser.domain.usecases.SearchUserUseCase
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
}