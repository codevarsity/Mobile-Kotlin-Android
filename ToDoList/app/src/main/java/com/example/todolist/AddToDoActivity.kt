package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddToDoActivity : AppCompatActivity() {

    lateinit var editText:EditText
    lateinit var doneButton:Button
    lateinit var cancelButtton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        editText = findViewById(R.id.todoEditText)
        doneButton = findViewById(R.id.doneButton)
        doneButton.setOnClickListener {
            val text = editText.text.toString()

            val intent = Intent()
            intent.putExtra("NEW_TODO", text)

            //send the intent to the parent activity
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
        cancelButtton = findViewById(R.id.cancelButton)
        cancelButtton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}