package com.example.helloandroidstudio

import android.util.Log

fun println(message:String){
    Log.i("MainActivity", message)

}


fun printName() {
    Log.i("MainActivity", "Amit Gulati")
}


class Student(var firstName:String, var lastName:String) {
    fun printStudent() {
        println("$firstName, $lastName")
    }
}
