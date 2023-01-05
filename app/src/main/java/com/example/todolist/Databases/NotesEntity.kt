package com.example.todolist.Databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var desc:String
)
