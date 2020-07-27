package com.yogadarma.consumerapp.framework.datasourceimpl

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import com.yogadarma.consumerapp.data.datasource.UserGithubDataSource
import com.yogadarma.consumerapp.data.db.ContentUri.Companion.CONTENT_URI
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.responses.DetailUserResponse
import com.yogadarma.consumerapp.framework.retrofit.NetworkApi
import io.reactivex.rxjava3.core.Observable

class UserGithubSourceImpl(
    private val networkApi: NetworkApi,
    private val context: Context
) : UserGithubDataSource {

    override fun getDetailUser(username: String): Observable<DetailUserResponse> =
        networkApi.getDetailUser(username)

    override fun getFollowerUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowerUser(username)

    override fun getFollowingUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowingUser(username)

    override fun getAllFavorite(): Cursor? =
        context.contentResolver.query(CONTENT_URI, null, null, null, null)

    override fun getFavoriteById(id: Int): Cursor? =
        context.contentResolver.query(Uri.parse("$CONTENT_URI/$id"), null, null, null, null)

    override fun insertFavorite(favorite: ContentValues): Uri? =
        context.contentResolver.insert(CONTENT_URI, favorite)

    override fun deleteFavorite(id: Int): Int =
        context.contentResolver.delete(Uri.parse("$CONTENT_URI/$id"), null, null)

}