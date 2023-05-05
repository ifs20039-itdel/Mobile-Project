package com.example.noteapp_11s20039.View

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_11s20038.View.NoteAddActivity
import com.example.noteapp_11s20039.Adapters.NoteAdapter
import com.example.noteapp_11s20039.Model.Note
import com.example.noteapp_11s20039.NoteApplication
import com.example.noteapp_11s20039.R
import com.example.noteapp_11s20039.ViewModel.NoteViewModel
import com.example.noteapp_11s20039.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    lateinit var addActivityResultLauncher: ActivityResultLauncher<Intent>
    lateinit var editActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.rvNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noteAdapter = NoteAdapter(this)
        recyclerView.adapter = noteAdapter
        registerActivityResultLauncher()

        val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)

        noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)
        noteViewModel.myAllNotes.observe(this, Observer { notes ->
            // Update UI
            noteAdapter.setNote (notes)
        })

        ItemTouchHelper (object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped (
                viewHolder: RecyclerView.ViewHolder, direction: Int) {noteViewModel .delete(noteAdapter.getNote(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(recyclerView)
    }

    fun registerActivityResultLauncher() {
        addActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            {resultAddNote ->
                val resultCode = resultAddNote.resultCode
                val data = resultAddNote.data

                if (resultCode == RESULT_OK && data != null) {
                    val noteTitle: String = data.getStringExtra("title").toString()
                    val noteDescription: String = data.getStringExtra("description").toString()

                    val note = Note(noteTitle, noteDescription)
                    noteViewModel.insert(note)
                }
            }
        )

        editActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            {resultEditNote ->
                val resultCode = resultEditNote.resultCode
                val data = resultEditNote.data

                if(resultCode == RESULT_OK && data != null){
                    val newTitle: String = data.getStringExtra("newTitle").toString()
                    val newDescription: String = data.getStringExtra("newDescription").toString()
                    val noteId = data.getIntExtra("noteId", -1)

                    val newNote = Note (newTitle, newDescription)

                    newNote.id = noteId
                    noteViewModel.update(newNote)
                }
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId) {
            R.id.miAddNote -> {
                val intent = Intent(this, NoteAddActivity::class.java)
                addActivityResultLauncher.launch(intent)
            }
            R.id.miDeleteNote -> {
                showDialogMessage()
            }
        }
        return true
    }

    fun showDialogMessage(){
        val dialogMessage = AlertDialog.Builder(this)
        dialogMessage.setTitle("Delete All Notes")
        dialogMessage.setMessage("If click Yes all notes will delete, if you want to delete specific note, please swipe left or right.")
        dialogMessage.setNegativeButton( "No", DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })
        dialogMessage.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            noteViewModel.deleteAllNotes()
        })
        dialogMessage.create().show()
    }
}