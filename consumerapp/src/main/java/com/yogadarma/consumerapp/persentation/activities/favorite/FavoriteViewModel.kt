package com.yogadarma.consumerapp.persentation.activities.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.usecases.GetFavoriteUseCase
import com.yogadarma.consumerapp.helper.MappingHelper

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