package com.yogadarma.githubuser.activities.main

import android.content.Context
import com.yogadarma.githubuser.models.User

interface MainContract {

    interface RequestDataCallback {
        fun onAgendaRequestCompleted(list: ArrayList<User>)
    }

    interface View {
        fun populateGithubUser(list: ArrayList<User>)
    }

    interface Presenter {
        fun requestDataUser()
    }

    interface Interactor {
        fun requestDataUserList(context: Context, callback: RequestDataCallback)
    }
}