package com.yogadarma.consumerapp.persentation.fragments.following

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.usecases.GetFollowingUserUseCase

class FollowingViewModel(private val followingUserUseCase: GetFollowingUserUseCase) :
    ViewModel() {

    private val followingData = MutableLiveData<ArrayList<UserData>?>()

    fun setFollowingData(username: String) {
        followingUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getFollowingData(): LiveData<ArrayList<UserData>?> = followingData

    private fun handleResponse(response: ArrayList<UserData>?) {
        followingData.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}