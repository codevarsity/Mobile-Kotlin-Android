package com.example.androidessetials

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View

class MainActivity : AppCompatActivity() {
    //activity lifecycle method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val layoutInflater = LayoutInflater.from(this)
//        val view = layoutInflater.inflate(R.layout.activity_main, null)
//        setContentView(view)

        setContentView(R.layout.activity_main)
    }

    fun browseWeb(view: View) {
        Log.i("MainActivity", "browseWeb called")
        //create an instance of intent class with Action = ACTION_VIEW
        //implict intent
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://www.engadget.com")
        startActivity(intent)
    }

    fun dialPhone(view:View) {
        //implicit intent
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:555555555")
        startActivity(intent)
    }

    fun launchSecond(view:View) {
        //explicit intent
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}