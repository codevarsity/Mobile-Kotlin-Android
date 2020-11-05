package com.example.helloandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //i is a static function in the Log class (Java terminology)
        Log.i("MainActivity", "Hello World!!")

        println("Hello World Again!!")

        printName()

        //arrayOf
        val names  = arrayOf("Amit", "Raj", "John", "Joe")
        val numbers = intArrayOf(1, 2, 3, 4)



        //doubleArrayOf()
        //floatArrayOf()
        numbers[0] + 5


        greet("Amit")

        var myVariable:String? = null


        val count = myVariable?.length ?: 0
        count + 5

        var airports = mapOf("DEL" to "New Delhi",
                             "BOM" to "Mumbai")

        val cityName = airports["DEL"]!!

        var max = 100
        var b = 200
        max  = if ( b > max) { b } else { max }

    }

    fun greet(name:String) {
        println("Hello !! $name")
    }


}