package com.yogadarma.githubuser.di

import com.yogadarma.githubuser.domain.usecases.GetDetailUserUseCase
import com.yogadarma.githubuser.domain.usecases.SearchUserUseCase
import com.yogadarma.githubuser.persentation.activities.detail.DetailViewModel
import com.yogadarma.githubuser.persentation.activities.main.MainViewModel
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
            get() as GetDetailUserUseCase
        )
    }
}