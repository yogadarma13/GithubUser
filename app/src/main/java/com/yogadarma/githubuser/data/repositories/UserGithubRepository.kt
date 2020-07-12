package com.yogadarma.githubuser.data.repositories

import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable

class UserGithubRepository(private val userGithubDataSource: UserGithubDataSource) :
    UserGithubDataSource {

    override fun searchUser(username: String): Observable<SearchUserResponse> =
        userGithubDataSource.searchUser(username)

    override fun getDetailUser(username: String): Observable<DetailUserResponse> =
        userGithubDataSource.getDetailUser(username)

}