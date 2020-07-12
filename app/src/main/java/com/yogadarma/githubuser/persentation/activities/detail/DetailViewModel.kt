package com.yogadarma.githubuser.persentation.activities.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.usecases.GetDetailUserUseCase

class DetailViewModel(private val detailUserUseCase: GetDetailUserUseCase) : ViewModel() {

    private val dataUser = MutableLiveData<DetailUserResponse>()

    fun setDetailUser(username: String) {
        detailUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getDetailUser(): LiveData<DetailUserResponse> = dataUser


    private fun handleResponse(response: DetailUserResponse) {
        dataUser.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}