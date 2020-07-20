package com.yogadarma.githubuser.persentation.activities.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.entity.Favorite
import com.yogadarma.githubuser.domain.usecases.GetFavoriteUseCase

class FavoriteViewModel(
    private val favoriteUseCase: GetFavoriteUseCase
) : ViewModel() {

    val allFavorite: LiveData<List<Favorite>> = favoriteUseCase.invoke()
}