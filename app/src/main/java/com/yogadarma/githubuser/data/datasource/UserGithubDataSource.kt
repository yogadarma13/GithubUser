package com.yogadarma.githubuser.data.datasource

import androidx.lifecycle.LiveData
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable

interface UserGithubDataSource {

    fun searchUser(username: String): Observable<SearchUserResponse>

    fun getDetailUser(username: String): Observable<DetailUserResponse>

    fun getFollowerUser(username: String): Observable<ArrayList<UserData>?>

    fun getFollowingUser(username: String): Observable<ArrayList<UserData>?>

    fun getAllFavorite(): LiveData<List<UserData>>

    fun getFavoriteById(id: Int): UserData

    suspend fun insertFavorite(favorite: UserData)

    suspend fun deleteFavorite(favorite: UserData)
}