package com.yogadarma.consumerapp.helper

import android.content.ContentValues
import android.database.Cursor
import com.yogadarma.consumerapp.domain.entity.UserData

class MappingHelper {
    companion object {
        fun mapCursorToArrayLits(favoritesCursor: Cursor?): ArrayList<UserData> {
            val favoriteList = ArrayList<UserData>()

            favoritesCursor?.apply {
                while (moveToNext()) {
                    val id = getInt(getColumnIndexOrThrow("id"))
                    val gistsUrl = getString(getColumnIndexOrThrow("gists_url"))
                    val reposUrl = getString(getColumnIndexOrThrow("repos_url"))
                    val followingUrl = getString(getColumnIndexOrThrow("following_url"))
                    val starredUrl = getString(getColumnIndexOrThrow("starred_url"))
                    val login = getString(getColumnIndexOrThrow("login"))
                    val followersUrl = getString(getColumnIndexOrThrow("followers_url"))
                    val type = getString(getColumnIndexOrThrow("type"))
                    val url = getString(getColumnIndexOrThrow("url"))
                    val subscriptionsUrl = getString(getColumnIndexOrThrow("subscriptions_url"))
                    val score = getDouble(getColumnIndexOrThrow("score"))
                    val receivedEventsUrl = getString(getColumnIndexOrThrow("received_events_url"))
                    val avatarUrl = getString(getColumnIndexOrThrow("avatar_url"))
                    val eventsUrl = getString(getColumnIndexOrThrow("events_url"))
                    val htmlUrl = getString(getColumnIndexOrThrow("html_url"))
                    val siteAdmin = getInt(getColumnIndexOrThrow("site_admin")) > 0
                    val gravatarId = getString(getColumnIndexOrThrow("gravatar_id"))
                    val nodeId = getString(getColumnIndexOrThrow("node_id"))
                    val organizationsUrl = getString(getColumnIndexOrThrow("organizations_url"))

                    favoriteList.add(
                        UserData(
                            id,
                            gistsUrl,
                            reposUrl,
                            followingUrl,
                            starredUrl,
                            login,
                            followersUrl,
                            type,
                            url,
                            subscriptionsUrl,
                            score,
                            receivedEventsUrl,
                            avatarUrl,
                            eventsUrl,
                            htmlUrl,
                            siteAdmin,
                            gravatarId,
                            nodeId,
                            organizationsUrl
                        )
                    )
                }
            }

            return favoriteList
        }

        fun convertFromContentValues(contentValues: ContentValues): UserData {
            val userData: UserData

            val id = contentValues.getAsInteger("id")
            val gistsUrl = contentValues.getAsString("gists_url")
            val reposUrl = contentValues.getAsString("repos_url")
            val followingUrl = contentValues.getAsString("following_url")
            val starredUrl = contentValues.getAsString("starred_url")
            val login = contentValues.getAsString("login")
            val followersUrl = contentValues.getAsString("followers_url")
            val type = contentValues.getAsString("type")
            val url = contentValues.getAsString("url")
            val subscriptionsUrl = contentValues.getAsString("subscriptions_url")
            val score = contentValues.getAsDouble("score")
            val receivedEventsUrl = contentValues.getAsString("received_events_url")
            val avatarUrl = contentValues.getAsString("avatar_url")
            val eventsUrl = contentValues.getAsString("events_url")
            val htmlUrl = contentValues.getAsString("html_url")
            val siteAdmin = contentValues.getAsBoolean("site_admin")
            val gravatarId = contentValues.getAsString("gravatar_id")
            val nodeId = contentValues.getAsString("node_id")
            val organizationsUrl = contentValues.getAsString("organizations_url")

            userData = UserData(
                id,
                gistsUrl,
                reposUrl,
                followingUrl,
                starredUrl,
                login,
                followersUrl,
                type,
                url,
                subscriptionsUrl,
                score,
                receivedEventsUrl,
                avatarUrl,
                eventsUrl,
                htmlUrl,
                siteAdmin,
                gravatarId,
                nodeId,
                organizationsUrl
            )
            return userData
        }

        fun convertToContentValues(userData: UserData): ContentValues {
            val values = ContentValues()

            values.put("id", userData.id)
            values.put("gists_url", userData.gistsUrl)
            values.put("repos_url", userData.reposUrl)
            values.put("following_url", userData.followingUrl)
            values.put("starred_url", userData.starredUrl)
            values.put("login", userData.login)
            values.put("followers_url", userData.followersUrl)
            values.put("type", userData.type)
            values.put("url", userData.url)
            values.put("subscriptions_url", userData.subscriptionsUrl)
            values.put("score", userData.score)
            values.put("received_events_url", userData.receivedEventsUrl)
            values.put("avatar_url", userData.avatarUrl)
            values.put("events_url", userData.eventsUrl)
            values.put("html_url", userData.htmlUrl)
            values.put("site_admin", userData.siteAdmin)
            values.put("gravatar_id", userData.gravatarId)
            values.put("node_id", userData.nodeId)
            values.put("organizations_url", userData.organizationsUrl)

            return values
        }
    }
}