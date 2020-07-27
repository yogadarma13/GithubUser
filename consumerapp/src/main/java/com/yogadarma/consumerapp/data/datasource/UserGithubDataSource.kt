package com.yogadarma.consumerapp.data.datasource

import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.responses.DetailUserResponse
import io.reactivex.rxjava3.core.Observable

interface UserGithubDataSource {

    fun getDetailUser(username: String): Observable<DetailUserResponse>

    fun getFollowerUser(username: String): Observable<ArrayList<UserData>?>

    fun getFollowingUser(username: String): Observable<ArrayList<UserData>?>

    fun getAllFavorite(): Cursor?

    fun getFavoriteById(id: Int): Cursor?

    fun insertFavorite(favorite: ContentValues): Uri?

    fun deleteFavorite(id: Int): Int
}