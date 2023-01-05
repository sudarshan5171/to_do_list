package com.example.todolist.Databases

import androidx.room.*

@Dao
interface NotesDao {
    @Insert
    suspend fun insertNote(entity: NotesEntity)

    @Update
    suspend fun updateNote(entity: NotesEntity)

    @Delete
    suspend fun deleteNote(entity: NotesEntity)

    @Query("Select * from NotesTable")
    suspend fun getAllNotes():List<NotesInfo>
}