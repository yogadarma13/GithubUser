package com.yogadarma.githubuser.activities.main

import android.content.Context
import com.yogadarma.githubuser.models.User

class MainPresenter(
    val mView: MainContract.View,
    private val mInteractor: MainInteractor = MainInteractor()
) : MainContract.Presenter {
    override fun requestDataUser() {
        mInteractor.requestDataUserList(mView as Context,
            object : MainContract.RequestDataCallback {
                override fun onAgendaRequestCompleted(list: ArrayList<User>) {
                    mView.populateGithubUser(list)
                }

            }
        )
    }


}