package com.example.imagedownloader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.net.URL

class MainActivity : AppCompatActivity() {

    val link = "https://www.nasa.gov/sites/default/files/thumbnails/image/stsci-h-p2001a-m-2000x1500_0.png"

    lateinit var imageView: ImageView
    lateinit var button: Button
    lateinit var receiver:BroadcastReceiver

    inner class UIUpdateReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("UIUpdateReceiver", "onReceive called")

           if ( SharedData.downloadedImage != null) {
               imageView.setImageBitmap(SharedData.downloadedImage)
           }
        }
    }

    override fun onResume() {
        super.onResume()
        receiver = UIUpdateReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.imagedownloaderservice")
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, ImageDownloaderService::class.java)
            intent.putExtra("IMAGE_LINK", link)
            startService(intent)

        }
    }
}