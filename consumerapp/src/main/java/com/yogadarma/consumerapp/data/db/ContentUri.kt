package com.yogadarma.consumerapp.data.db

import android.net.Uri

class ContentUri {

    companion object {
        private const val AUTHORITY = "com.yogadarma.githubuser"
        private const val SCHEME = "content"
        private const val TABLE_NAME = "favorite"

        val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(TABLE_NAME)
            .build()
    }
}