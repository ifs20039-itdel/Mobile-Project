package com.example.noteapp_11s20039.Repository

import androidx.annotation.WorkerThread
import com.example.noteapp_11s20039.Model.Note
import com.example.noteapp_11s20039.Room.NoteDAO
import kotlinx.coroutines.flow.Flow

class NoteRepository (private val noteDao : NoteDAO){

    val myAllNotes : Flow<List<Note>> = noteDao.getALlNotes()

    @WorkerThread
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun update(note: Note){
        noteDao.update(note)
    }

    @WorkerThread
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes(){
        noteDao.deleteAllNotes()
    }
}