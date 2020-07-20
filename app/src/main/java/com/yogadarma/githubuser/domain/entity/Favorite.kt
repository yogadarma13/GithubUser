package com.yogadarma.githubuser.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,

    @ColumnInfo(name = "bio")
    val bio: String,

    @ColumnInfo(name = "repos_url")
    val reposUrl: String,

    @ColumnInfo(name = "following_url")
    val followingUrl: String,

    @ColumnInfo(name = "followers_url")
    val followersUrl: String,

    @ColumnInfo(name = "company")
    val company: String

)