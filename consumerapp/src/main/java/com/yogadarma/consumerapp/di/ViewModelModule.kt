package com.yogadarma.consumerapp.di

import com.yogadarma.consumerapp.domain.usecases.*
import com.yogadarma.consumerapp.persentation.activities.detail.DetailViewModel
import com.yogadarma.consumerapp.persentation.activities.favorite.FavoriteViewModel
import com.yogadarma.consumerapp.persentation.fragments.follower.FollowerViewModel
import com.yogadarma.consumerapp.persentation.fragments.following.FollowingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        DetailViewModel(
            get() as GetDetailUserUseCase,
            get() as GetFollowerUserUseCase,
            get() as GetFollowingUserUseCase,
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