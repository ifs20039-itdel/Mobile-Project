package com.example.noteapp_11s20038.View
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteapp_11s20039.R

class NoteAddActivity : AppCompatActivity() {

    lateinit var etTitle: EditText
    lateinit var etDescription: EditText
    lateinit var btnCancel: Button
    lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        supportActionBar?.title = "Add Note"

        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        btnCancel = findViewById(R.id.btnCancel)
        btnSave = findViewById(R.id.btnSave)

        btnCancel.setOnClickListener {
            Toast.makeText(applicationContext, "Nothing saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnSave.setOnClickListener {
            saveNote()
        }

    }

    fun saveNote() {
        val noteTitle: String = etTitle.text.toString()
        val noteDescription: String = etDescription.text.toString()

        val intent = Intent()
        intent.putExtra("title", noteTitle)
        intent.putExtra("description", noteDescription)
        setResult(RESULT_OK, intent)
        finish()
    }
}