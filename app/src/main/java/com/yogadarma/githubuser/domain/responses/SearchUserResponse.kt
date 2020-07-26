package com.yogadarma.githubuser.domain.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yogadarma.githubuser.domain.entity.UserData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchUserResponse(

    @field:SerializedName("total_count")
    val totalCount: Int? = null,

    @field:SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @field:SerializedName("items")
    val items: ArrayList<UserData>? = null
) : Parcelable
