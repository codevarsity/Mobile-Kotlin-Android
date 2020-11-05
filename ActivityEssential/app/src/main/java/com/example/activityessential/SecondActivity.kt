package com.example.activityessential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SecondActivity", "onCreate")
        setContentView(R.layout.activity_second)
        textView = findViewById(R.id.textView2)

        val launchingIntent = getIntent()
        if( launchingIntent.extras != null) {
            val text = launchingIntent.getStringExtra("USER_TEXT")
            textView.text = text
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("SecondActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("SecondActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SecondActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SecondActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SecondActivity", "onDestroy")
    }
}