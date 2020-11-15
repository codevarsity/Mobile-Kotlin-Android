package com.example.activityessentials

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editText:EditText
    lateinit var sendButton: Button


    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")

    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate")

        val launchingIntent = getIntent()
        if(launchingIntent.extras != null) {
            Log.i("MainActivity", "launching intent has extras")
        } else {
            Log.i("MainActivity", "launching intent has NO extras")
        }

        editText = findViewById(R.id.editText)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            Log.i("MainActivity", "Button Tapped")
            val text = editText.text.toString()
            Log.i("MainActivity", "User entered = $text")

            //explicit intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("MESSAGE", text)
            startActivity(intent)
        }
    }

    fun send(view: View) {
        Log.i("MainActivity", "Send button")
    }
}