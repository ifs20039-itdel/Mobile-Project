package com.example.noteapp_11s20039.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_11s20039.Model.Note
import com.example.noteapp_11s20039.R
import com.example.noteapp_11s20039.View.MainActivity
import com.example.noteapp_11s20039.View.NoteEditActivity

class NoteAdapter (private val activity: MainActivity):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes: List<Note> = ArrayList()

    class NoteViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView =
            itemView.findViewById(R.id.tvDescription)
        val cvNote: CardView = itemView.findViewById(R.id.cvNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote: Note = notes[position]

        holder.tvTitle.text = currentNote.title
        holder.tvDescription.text = currentNote.description

        holder.cvNote.setOnClickListener {
            val intent =
                Intent(activity, NoteEditActivity::class.java)
            intent.putExtra("currentTitle", currentNote.title)
            intent.putExtra(
                "currentDescription", currentNote.description
            )
            intent.putExtra("currentId", currentNote.id)

            //activity result launcher

            activity.editActivityResultLauncher.launch(intent)

        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
    fun setNote(myNotes : List<Note>) {
        this.notes = myNotes
        notifyDataSetChanged()
    }

    fun getNote(position: Int): Note {
        return notes[position]
    }
}

