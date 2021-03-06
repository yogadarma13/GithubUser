package com.yogadarma.consumerapp.persentation.activities.detail

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.responses.DetailUserResponse
import com.yogadarma.consumerapp.domain.usecases.*

class DetailViewModel(
    private val detailUserUseCase: GetDetailUserUseCase,
    private val favoriteByIdUseCase: GetFavoriteByIdUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val dataUser = MutableLiveData<DetailUserResponse>()
    private val favoriteUser = MutableLiveData<Cursor>()

    fun setDetailUser(username: String) {
        detailUserUseCase.invoke(username).subscribe(this::handleResponseDetail, this::handleError)
    }

    fun setFavoriteUser(favorite: ContentValues) {
        addFavoriteUseCase.invoke(favorite)
    }

    fun deleteFavoriteUser(id: Int) {
        deleteFavoriteUseCase.invoke(id)
    }

    fun setFavoriteById(id: Int) {
        val cursorFavorite = favoriteByIdUseCase.invoke(id)
        favoriteUser.postValue(cursorFavorite)
    }

    fun getFavoriteById(): LiveData<Cursor> = favoriteUser

    fun getDetailUser(): LiveData<DetailUserResponse> = dataUser

    private fun handleResponseDetail(response: DetailUserResponse) {
        dataUser.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}