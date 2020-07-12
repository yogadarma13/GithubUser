package com.yogadarma.githubuser.persentation.fragments.follower

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.domain.usecases.GetFollowerUserUseCase

class FollowerViewModel(private val getFollowerUserUseCase: GetFollowerUserUseCase) : ViewModel() {

    private val followerData = MutableLiveData<ArrayList<UserData>?>()

    fun setFollowerData(username: String) {
        getFollowerUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getFollowerData(): LiveData<ArrayList<UserData>?> = followerData

    private fun handleResponse(response: ArrayList<UserData>?) {
        followerData.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}