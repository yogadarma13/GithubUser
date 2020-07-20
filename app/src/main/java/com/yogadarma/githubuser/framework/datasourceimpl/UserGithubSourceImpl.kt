package com.yogadarma.githubuser.framework.datasourceimpl

import androidx.lifecycle.LiveData
import com.yogadarma.githubuser.data.datasource.UserGithubDataSource
import com.yogadarma.githubuser.data.db.dao.FavoriteDao
import com.yogadarma.githubuser.domain.entity.Favorite
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.framework.retrofit.NetworkApi
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserGithubSourceImpl(
    private val networkApi: NetworkApi,
    private val favoriteDao: FavoriteDao
) : UserGithubDataSource {

    override fun searchUser(username: String): Observable<SearchUserResponse> =
        networkApi.searchUser(username)

    override fun getDetailUser(username: String): Observable<DetailUserResponse> =
        networkApi.getDetailUser(username)

    override fun getFollowerUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowerUser(username)

    override fun getFollowingUser(username: String): Observable<ArrayList<UserData>?> =
        networkApi.getFollowingUser(username)

    override fun getAllFavorite(): LiveData<List<Favorite>> = favoriteDao.getAllFavorite()

    override suspend fun insertFavorite(favorite: Favorite) =
        favoriteDao.insertFavorite(favorite)

}