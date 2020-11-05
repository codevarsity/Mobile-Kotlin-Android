package com.example.activityessential

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    lateinit var userEditText:EditText
    lateinit var userTextView: TextView
    lateinit var userButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        var launchingIntent = getIntent()


        initializeUI()
    }

    fun initializeUI() {
        userEditText = findViewById(R.id.userEditText)
        userTextView = findViewById(R.id.userTextView)

        userEditText.text.clear()
        userTextView.text = ""

        userButton = findViewById(R.id.userButton)
        userButton.setOnClickListener {
            Log.i("MyOnClickListener", "OnClick Listener called")

            userTextView.text = userEditText.text

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER_TEXT", userEditText.text.toString() )
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
}

//SAM interfaces