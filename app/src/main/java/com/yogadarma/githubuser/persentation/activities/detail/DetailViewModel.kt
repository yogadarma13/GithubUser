package com.yogadarma.githubuser.persentation.activities.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.domain.usecases.GetDetailUserUseCase
import com.yogadarma.githubuser.domain.usecases.GetFollowerUserUseCase
import com.yogadarma.githubuser.domain.usecases.GetFollowingUserUseCase

class DetailViewModel(
    private val detailUserUseCase: GetDetailUserUseCase,
    private val followerUserUseCase: GetFollowerUserUseCase,
    private val followingUserUseCase: GetFollowingUserUseCase
) : ViewModel() {

    private val dataUser = MutableLiveData<DetailUserResponse>()
    private val followerUser = MutableLiveData<ArrayList<UserData>?>()
    private val followingUser = MutableLiveData<ArrayList<UserData>?>()

    fun setDetailUser(username: String) {
        detailUserUseCase.invoke(username).subscribe(this::handleResponseDetail, this::handleError)
        followerUserUseCase.invoke(username).subscribe(this::handleResponseFollower, this::handleError)
        followingUserUseCase.invoke(username).subscribe(this::handleResponseFollowing, this::handleError)
    }

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