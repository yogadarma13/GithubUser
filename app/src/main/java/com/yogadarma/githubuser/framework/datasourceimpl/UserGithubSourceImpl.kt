package com.yogadarma.githubuser.framework.datasourceimpl

import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.framework.retrofit.NetworkApi
import io.reactivex.rxjava3.core.Observable

class UserGithubSourceImpl(private val networkApi: NetworkApi) : UserGithubDataSource {

    override fun searchUser(username: String): Observable<SearchUserResponse> =
        networkApi.searchUser(username)

    override fun getDetailUser(username: String): Observable<DetailUserResponse> =
        networkApi.getDetailUser(username)

    override fun getFollowerUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowerUser(username)

    override fun getFollowingUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowingUser(username)
}