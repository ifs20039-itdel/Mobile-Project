package com.example.noteapp_11s20039.View

import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteapp_11s20039.R

class NoteEditActivity : AppCompatActivity() {

    lateinit var etTitle : EditText
    lateinit var etDescription: EditText
    lateinit var btnCancel : Button
    lateinit var  btnSave : Button

    var currentId = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_edit)

        supportActionBar?.title = "Edit Note"

        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        btnCancel = findViewById(R.id.btnCancel)
        btnSave = findViewById(R.id.btnSave)

        getAndSetData()

        btnCancel.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Nothing updated",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }

        btnSave.setOnClickListener {
            updateNote()
        }
    }

    fun updateNote(){
        val newTitle = etTitle.text.toString()
        val newDescription = etDescription.text.toString()

        val intent = Intent()
        intent.putExtra("newTitle", newTitle)
        intent.putExtra("newDescription",newDescription)
        if(currentId != -1){
            intent.putExtra("noteId", currentId)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun getAndSetData(){
        //get
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDescription =
            intent.getStringExtra("currentDescription")
        currentId = intent.getIntExtra("currentId", -1)

        //set
        etTitle.setText(currentTitle)
        etDescription.setText(currentDescription)
    }
}