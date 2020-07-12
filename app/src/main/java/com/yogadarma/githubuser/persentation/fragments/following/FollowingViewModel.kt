package com.yogadarma.githubuser.persentation.fragments.following

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.domain.usecases.GetFollowingUserUseCase

class FollowingViewModel(private val getFollowingUserUseCase: GetFollowingUserUseCase) :
    ViewModel() {

    private val followingData = MutableLiveData<ArrayList<UserData>?>()

    fun setFollowingData(username: String) {
        getFollowingUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getFollowingData(): LiveData<ArrayList<UserData>?> = followingData

    private fun handleResponse(response: ArrayList<UserData>?) {
        followingData.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}