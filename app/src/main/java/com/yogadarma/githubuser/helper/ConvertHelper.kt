package com.yogadarma.githubuser.helper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL

class ConvertHelper {
    companion object {
        fun getImageBitmap(urlImage: String): Bitmap? {
            var bitmap: Bitmap? = null

            try {
                val url = URL(urlImage)
                val conn = url.openConnection()
                conn.connect()
                val inputStream: InputStream = conn.getInputStream()
                val bis = BufferedInputStream(inputStream)
                bitmap = BitmapFactory.decodeStream(bis)
                bis.close()
                inputStream.close()
            } catch (e: IOException) {
                Log.e("Error", "Error getting bitmap", e);
            }

            return bitmap
        }
    }
}