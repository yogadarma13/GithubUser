package com.yogadarma.consumerapp.persentation.fragments.follower

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.usecases.GetFollowerUserUseCase

class FollowerViewModel(private val followerUserUseCase: GetFollowerUserUseCase) : ViewModel() {

    private val followerData = MutableLiveData<ArrayList<UserData>?>()

    fun setFollowerData(username: String) {
        followerUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getFollowerData(): LiveData<ArrayList<UserData>?> = followerData

    private fun handleResponse(response: ArrayList<UserData>?) {
        followerData.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}