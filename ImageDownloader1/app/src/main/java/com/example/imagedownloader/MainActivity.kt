package com.example.imagedownloader

import android.content.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.net.URL

fun SharedPreferences.myEdit(action: SharedPreferences.Editor.()->Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}

class MainActivity : AppCompatActivity() {
    val link = "https://www.nasa.gov/sites/default/files/thumbnails/image/stsci-h-p2001a-m-2000x1500_0.png"
    lateinit var imageView:ImageView
    lateinit var button:Button
    lateinit var receiver:BroadcastReceiver

    inner class ImageDownloadReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("ImageDownloadReceiver", "onReceive")

            imageView.setImageBitmap(SharedData.bitmapData)
        }

    }

    override fun onResume() {
        super.onResume()
        receiver = ImageDownloadReceiver()
        val intentFilter = IntentFilter("com.example.imagedownloader.IMAGE_SUCCESS")
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

        val sharedPreference = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreference.myEdit{

        }

    }


}