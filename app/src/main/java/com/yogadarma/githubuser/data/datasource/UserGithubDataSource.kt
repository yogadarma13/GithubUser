package com.yogadarma.githubuser.data.datasource

import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable

interface UserGithubDataSource {

    fun searchUser(username: String): Observable<SearchUserResponse>

    fun getDetailUser(username: String): Observable<DetailUserResponse>
}