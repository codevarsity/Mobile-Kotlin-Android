package com.example.imagedownloader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class StartupReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("StartupReceive", "onReceive")
    }
}
