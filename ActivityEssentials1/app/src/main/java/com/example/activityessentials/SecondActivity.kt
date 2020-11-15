package com.example.activityessentials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView2)
        textView.text = ""
        button = findViewById(R.id.button2)

        button.setOnClickListener {
            finish()
        }

        val launchingIntent = getIntent()
        if (launchingIntent.extras != null) {
            val message = launchingIntent.getStringExtra("MESSAGE")
            textView.text = message
        }

    }

    fun back(view: View) {
        finish()
    }
}