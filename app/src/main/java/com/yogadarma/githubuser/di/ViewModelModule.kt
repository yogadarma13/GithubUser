package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.domain.usecases.*
import com.yogadarma.githubuser.persentation.activities.detail.DetailViewModel
import com.yogadarma.githubuser.persentation.activities.favorite.FavoriteViewModel
import com.yogadarma.githubuser.persentation.activities.main.MainViewModel
import com.yogadarma.githubuser.persentation.fragments.follower.FollowerViewModel
import com.yogadarma.githubuser.persentation.fragments.following.FollowingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(
            get() as SearchUserUseCase
        )
    }

    viewModel {
        DetailViewModel(
            get() as GetDetailUserUseCase,
            get() as GetFavoriteByIdUseCase,
            get() as AddFavoriteUseCase,
            get() as DeleteFavoriteUseCase
        )
    }

    viewModel {
        FollowerViewModel(
            get() as GetFollowerUserUseCase
        )
    }

    viewModel {
        FollowingViewModel(
            get() as GetFollowingUserUseCase
        )
    }

    viewModel {
        FavoriteViewModel(
            get() as GetFavoriteUseCase
        )
    }
}