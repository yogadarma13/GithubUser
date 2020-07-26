package com.yogadarma.githubuser.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.yogadarma.githubuser.data.db.dao.FavoriteDao
import com.yogadarma.githubuser.helper.MappingHelper
import org.koin.android.ext.android.inject

class GithubUserProvider : ContentProvider() {

    companion object {

        private const val AUTHORITY = "com.yogadarma.githubuser"
        private const val SCHEME = "content"
        private const val TABLE_NAME = "favorite"
        private const val FAVORITE = 1
        private const val FAVORITE_ID = 2

        val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(TABLE_NAME)
            .build()

        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        init {
            sUriMatcher.addURI(AUTHORITY, TABLE_NAME, FAVORITE)

            sUriMatcher.addURI(AUTHORITY, "$TABLE_NAME/#", FAVORITE_ID)
        }
    }

    private val favoriteDao: FavoriteDao by inject()

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {

        return when (sUriMatcher.match(uri)) {
            FAVORITE -> favoriteDao.getAllFavorite()
            FAVORITE_ID -> favoriteDao.getFavoriteById(uri.lastPathSegment!!.toInt())
            else -> null
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val deleteId: Int = when (FAVORITE_ID) {
            sUriMatcher.match(uri) -> favoriteDao.deleteFavorite(uri.lastPathSegment!!.toInt())
            else -> 0
        }
        context?.contentResolver?.notifyChange(CONTENT_URI, null)

        return deleteId
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val addId: Long = when (FAVORITE) {
            sUriMatcher.match(uri) -> favoriteDao.insertFavorite(values?.let {
                MappingHelper.convertFromContentValues(
                    it
                )
            })
            else -> 0
        }

        context?.contentResolver?.notifyChange(CONTENT_URI, null)

        return Uri.parse("$CONTENT_URI/$addId")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}
