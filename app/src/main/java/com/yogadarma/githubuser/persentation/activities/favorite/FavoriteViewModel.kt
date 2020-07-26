package com.yogadarma.githubuser.persentation.activities.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.usecases.GetFavoriteUseCase
import com.yogadarma.githubuser.helper.MappingHelper

class FavoriteViewModel(
    private val favoriteUseCase: GetFavoriteUseCase
) : ViewModel() {

    private val resultFavoriteList = MutableLiveData<ArrayList<UserData>>()

    fun setFavoriteList() {
        val cursorFavorite = favoriteUseCase.invoke()
        val favoriteList = MappingHelper.mapCursorToArrayLits(cursorFavorite)
        resultFavoriteList.postValue(favoriteList)
    }

    fun getFavoriteList(): LiveData<ArrayList<UserData>> = resultFavoriteList
}