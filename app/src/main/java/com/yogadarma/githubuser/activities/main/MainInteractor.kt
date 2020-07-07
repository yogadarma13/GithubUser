package com.yogadarma.githubuser.activities.main

import android.content.Context
import android.content.res.TypedArray
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.models.User

class MainInteractor : MainContract.Interactor {

    private val users: ArrayList<User> = arrayListOf()

    override fun requestDataUserList(context: Context, callback: MainContract.RequestDataCallback) {
        val dataUsername: Array<String> = context.resources.getStringArray(R.array.username)
        val dataName: Array<String> = context.resources.getStringArray(R.array.name)
        val dataAvatar: TypedArray = context.resources.obtainTypedArray(R.array.avatar)
        val dataCompany: Array<String> = context.resources.getStringArray(R.array.company)
        val dataLocation: Array<String> = context.resources.getStringArray(R.array.location)
        val dataRepository: Array<String> = context.resources.getStringArray(R.array.repository)
        val dataFollower: Array<String> = context.resources.getStringArray(R.array.followers)
        val dataFollowing: Array<String> = context.resources.getStringArray(R.array.following)
        for (position in dataUsername.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataAvatar.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        callback.onAgendaRequestCompleted(users)
    }
}