package com.yogadarma.githubuser.data.datasource

import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable

interface UserGithubDataSource {

    fun searchUser(username: String): Observable<SearchUserResponse>

    fun getDetailUser(username: String): Observable<DetailUserResponse>

    fun getFollowerUser(username: String): Observable<ArrayList<UserData>?>

    fun getFollowingUser(username: String): Observable<ArrayList<UserData>?>

    fun getAllFavorite(): Cursor?

    fun getFavoriteById(id: Int): Cursor?

    fun insertFavorite(favorite: ContentValues): Uri?

    fun deleteFavorite(id: Int): Int
}