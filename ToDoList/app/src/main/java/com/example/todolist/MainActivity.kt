package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var addButton:Button
    lateinit var toDoListTextView:TextView
    var items:MutableList<String> = mutableListOf("Get Milk", "Attend Training")

    fun itemsToString():String {
        var retVal = StringBuffer()
        for (item in items) {
            retVal.append("$item \n")
        }
        return retVal.toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( requestCode == 101 &&
            resultCode == Activity.RESULT_OK &&
            data != null) {
            val todo = data.getStringExtra("NEW_TODO")
            if (todo != null) {
                items.add(todo)
                //update the textview
                toDoListTextView.text = itemsToString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.addButton)
        addButton.setOnClickListener{
            val intent = Intent(this, AddToDoActivity::class.java)
            startActivityForResult(intent, 101)
        }
        toDoListTextView = findViewById(R.id.textView)
        toDoListTextView.text = itemsToString()
    }
}