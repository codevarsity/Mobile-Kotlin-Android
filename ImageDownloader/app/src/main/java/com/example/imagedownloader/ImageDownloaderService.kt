package com.example.imagedownloader

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ImageDownloaderService : IntentService("ImageDownloaderService") {

    override fun onCreate() {
        super.onCreate()
        Log.i("ImageDownloaderService", "onCreate")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i("ImageDownloaderService", "onHandleIntent")

        val link = intent?.getStringExtra("IMAGE_LINK")
        if ( link != null) {
            val bitmap = NetworkUtility.getImage(link)
            if (bitmap != null) {
                Log.i("ImageDownloader", "Image Downloaded successfully")

                SharedData.downloadedImage = bitmap

                val intent = Intent("com.example.imagedownloaderservice")
                sendBroadcast(intent)

            }
        }

    }
}
