package com.example.imagedownloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

class NetworkUtils {
    companion object {
        fun getImage(link:String): Bitmap? {
            val url = URL(link)
            val connection = url.openConnection()
            val inputStream = connection.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap
        }
    }
}