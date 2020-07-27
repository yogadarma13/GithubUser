package com.yogadarma.githubuser.widget

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.os.Binder
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.os.bundleOf
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.helper.ConvertHelper
import com.yogadarma.githubuser.helper.MappingHelper
import com.yogadarma.githubuser.provider.GithubUserProvider.Companion.CONTENT_URI

class StackRemoteViewsFactory(private val mContext: Context) :
    RemoteViewsService.RemoteViewsFactory {

    private val mWidgetItems = ArrayList<Bitmap>()
    private var mList = ArrayList<UserData>()
    private var cursor: Cursor? = null

    override fun onCreate() {
    }

    override fun onDataSetChanged() {
        cursor?.close()

        val identityToken = Binder.clearCallingIdentity()

        cursor = mContext.contentResolver.query(CONTENT_URI, null, null, null, null)

        mList = MappingHelper.mapCursorToArrayLits(cursor)
        mList.forEach {
            ConvertHelper.getImageBitmap(it.avatarUrl.toString())
                ?.let { it1 -> mWidgetItems.add(it1) }
        }

        Binder.restoreCallingIdentity(identityToken)
    }


    override fun getViewAt(position: Int): RemoteViews {
        val rv = RemoteViews(mContext.packageName, R.layout.widget_item)
        rv.setImageViewBitmap(R.id.imageView, mWidgetItems[position])
        val extras = bundleOf(
            ImageBannerWidget.EXTRA_ITEM to mList[position].login
        )
        val fillInIntent = Intent()
        fillInIntent.putExtras(extras)
        rv.setOnClickFillInIntent(R.id.imageView, fillInIntent)
        return rv
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = mWidgetItems.size

    override fun getViewTypeCount(): Int = 1

    override fun hasStableIds(): Boolean = false

    override fun onDestroy() {
    }

}