package com.yogadarma.githubuser.data.repositories

import android.content.ContentValues
import android.database.Cursor
import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable

class UserGithubRepository(private val userGithubDataSource: UserGithubDataSource) :
    UserGithubDataSource {

    override fun searchUser(username: String): Observable<SearchUserResponse> =
        userGithubDataSource.searchUser(username)

    override fun getDetailUser(username: String): Observable<DetailUserResponse> =
        userGithubDataSource.getDetailUser(username)

    override fun getFollowerUser(username: String): Observable<ArrayList<UserData>?> =
        userGithubDataSource.getFollowerUser(username)

    override fun getFollowingUser(username: String): Observable<ArrayList<UserData>?> =
        userGithubDataSource.getFollowingUser(username)

    override fun getAllFavorite(): Cursor? = userGithubDataSource.getAllFavorite()

    override fun getFavoriteById(id: Int): Cursor? = userGithubDataSource.getFavoriteById(id)

    override fun insertFavorite(favorite: ContentValues) =
        userGithubDataSource.insertFavorite(favorite)

    override fun deleteFavorite(id: Int): Int = userGithubDataSource.deleteFavorite(id)

}