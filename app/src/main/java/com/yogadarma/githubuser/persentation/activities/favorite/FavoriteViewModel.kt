package com.yogadarma.githubuser.persentation.activities.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.usecases.GetFavoriteUseCase

class FavoriteViewModel(
    favoriteUseCase: GetFavoriteUseCase
) : ViewModel() {

    val allFavorite: LiveData<List<UserData>> = favoriteUseCase.invoke()
}