package com.yogadarma.consumerapp.framework.retrofit

import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.domain.responses.DetailUserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {

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