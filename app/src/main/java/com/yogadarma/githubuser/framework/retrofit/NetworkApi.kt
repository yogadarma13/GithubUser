package com.yogadarma.githubuser.framework.retrofit

import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApi {

    @GET("search/users")
    fun searchUser(
        @Query("q") username: String
    ): Observable<SearchUserResponse>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ): Observable<DetailUserResponse>

    @GET("users/{username}/followers")
    fun getFollowerUser(
        @Path("username") username: String
    ): Observable<ArrayList<UserData>?>

    @GET("users/{username}/following")
    fun getFollowingUser(
        @Path("username") username: String
    ): Observable<ArrayList<UserData>?>
}