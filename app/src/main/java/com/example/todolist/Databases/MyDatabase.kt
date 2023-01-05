package com.example.todolist.Databases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NotesEntity::class], version = 1)
abstract class myDatabase : RoomDatabase(){
    abstract fun dao(): NotesDao
}