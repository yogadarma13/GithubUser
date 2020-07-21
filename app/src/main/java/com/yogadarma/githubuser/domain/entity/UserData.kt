package com.yogadarma.githubuser.domain.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favorite")
data class UserData(

    @field:SerializedName("id")
    @PrimaryKey
    val id: Int? = null,

    @field:SerializedName("gists_url")
    @ColumnInfo(name = "gists_url")
    val gistsUrl: String? = null,

    @field:SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    val reposUrl: String? = null,

    @field:SerializedName("following_url")
    @ColumnInfo(name = "following_url")
    val followingUrl: String? = null,

    @field:SerializedName("starred_url")
    @ColumnInfo(name = "starred_url")
    val starredUrl: String? = null,

    @field:SerializedName("login")
    @ColumnInfo(name = "login")
    val login: String? = null,

    @field:SerializedName("followers_url")
    @ColumnInfo(name = "followers_url")
    val followersUrl: String? = null,

    @field:SerializedName("type")
    @ColumnInfo(name = "type")
    val type: String? = null,

    @field:SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String? = null,

    @field:SerializedName("subscriptions_url")
    @ColumnInfo(name = "subscriptions_url")
    val subscriptionsUrl: String? = null,

    @field:SerializedName("score")
    @ColumnInfo(name = "score")
    val score: Double? = null,

    @field:SerializedName("received_events_url")
    @ColumnInfo(name = "received_events_url")
    val receivedEventsUrl: String? = null,

    @field:SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("events_url")
    @ColumnInfo(name = "events_url")
    val eventsUrl: String? = null,

    @field:SerializedName("html_url")
    @ColumnInfo(name = "html_url")
    val htmlUrl: String? = null,

    @field:SerializedName("site_admin")
    @ColumnInfo(name = "site_admin")
    val siteAdmin: Boolean? = null,

    @field:SerializedName("gravatar_id")
    @ColumnInfo(name = "gravatar_id")
    val gravatarId: String? = null,

    @field:SerializedName("node_id")
    @ColumnInfo(name = "node_id")
    val nodeId: String? = null,

    @field:SerializedName("organizations_url")
    @ColumnInfo(name = "organizations_url")
    val organizationsUrl: String? = null
) : Parcelable
