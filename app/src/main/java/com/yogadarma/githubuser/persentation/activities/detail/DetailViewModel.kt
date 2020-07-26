package com.yogadarma.githubuser.persentation.activities.detail

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.usecases.*

class DetailViewModel(
    private val detailUserUseCase: GetDetailUserUseCase,
    private val followerUserUseCase: GetFollowerUserUseCase,
    private val followingUserUseCase: GetFollowingUserUseCase,
    private val favoriteByIdUseCase: GetFavoriteByIdUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val dataUser = MutableLiveData<DetailUserResponse>()
    private val followerUser = MutableLiveData<ArrayList<UserData>?>()
    private val followingUser = MutableLiveData<ArrayList<UserData>?>()
    private val favoriteUser = MutableLiveData<Cursor>()

    fun setDetailUser(username: String) {
        detailUserUseCase.invoke(username).subscribe(this::handleResponseDetail, this::handleError)
        followerUserUseCase.invoke(username)
            .subscribe(this::handleResponseFollower, this::handleError)
        followingUserUseCase.invoke(username)
            .subscribe(this::handleResponseFollowing, this::handleError)
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

    fun getFollowerUser(): LiveData<ArrayList<UserData>?> = followerUser

    fun getFollowingUser(): LiveData<ArrayList<UserData>?> = followingUser

    private fun handleResponseDetail(response: DetailUserResponse) {
        dataUser.postValue(response)
    }

    private fun handleResponseFollower(response: ArrayList<UserData>?) {
        followerUser.postValue(response)
    }

    private fun handleResponseFollowing(response: ArrayList<UserData>?) {
        followingUser.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}