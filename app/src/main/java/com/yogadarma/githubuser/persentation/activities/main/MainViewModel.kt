package com.yogadarma.githubuser.persentation.activities.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import com.yogadarma.githubuser.domain.usecases.SearchUserUseCase

class MainViewModel(private val searchUserUseCase: SearchUserUseCase): ViewModel() {

    val resultSearch = MutableLiveData<SearchUserResponse>()

    fun setResultSearch(username: String) {
        searchUserUseCase.invoke(username).subscribe(this::handleResponse, this::handleError)
    }

    fun getResultSearch(): LiveData<SearchUserResponse> {
        return resultSearch
    }

    private fun handleResponse(response: SearchUserResponse) {
        resultSearch.postValue(response)
    }

    private fun handleError(error: Throwable) {
        Log.d("onFailure", error.message.toString())
    }
}