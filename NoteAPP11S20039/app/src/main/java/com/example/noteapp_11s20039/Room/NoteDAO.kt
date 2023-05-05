package com.example.noteapp_11s20039.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp_11s20039.Model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Insert
    suspend fun insert(note : Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getALlNotes() : Flow<List<Note>>
}