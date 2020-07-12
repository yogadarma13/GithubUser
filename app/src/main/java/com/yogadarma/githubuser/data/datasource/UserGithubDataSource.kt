package com.yogadarma.githubuser.data.datasource

import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import com.yogadarma.githubuser.domain.responses.UserData
import io.reactivex.rxjava3.core.Observable

interface UserGithubDataSource {

    fun searchUser(username: String): Observable<SearchUserResponse>

    fun getDetailUser(username: String): Observable<DetailUserResponse>

    fun getFollowerUser(username: String): Observable<ArrayList<UserData>?>

    fun getFollowingUser(username: String): Observable<ArrayList<UserData>?>
}