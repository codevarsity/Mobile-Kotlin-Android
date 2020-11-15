package com.example.imagedownloader

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ImageDownloaderService : IntentService("IMAGE_DOWNLOADER") {

    override fun onCreate() {
        super.onCreate()
        Log.i("ImageDownloaderService", "onCreate")
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            val link = intent.getStringExtra("IMAGE_LINK")
            if (link != null) {
                Thread.sleep(10000)
                val bitmap = NetworkUtils.getImage(link)
                if (bitmap != null) {
                    Log.i("ImageDownloaderService", "Image Downloaded Successfully")
                    SharedData.bitmapData = bitmap
                    val intent = Intent("com.example.imagedownloader.IMAGE_SUCCESS")
                    sendBroadcast(intent)
                } else {
                    Log.i("ImageDownloaderService", "Failed to download image")
                }




            }
        }
    }
}
