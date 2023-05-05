package com.example.noteapp_11s20039.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note (val title : String, val description: String){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}