package com.example.todolist.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.todolist.Databases.DataObject
import com.example.todolist.Databases.NotesEntity
import com.example.todolist.R
import com.example.todolist.Databases.myDatabase
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_add_note.etNoteTitle
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_add_note.etNoteDesc as etNoteDesc1

class AddNoteActivity : AppCompatActivity() {

    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "NotesTable"
        ).build()

        btnSave.setOnClickListener(View.OnClickListener {
            var title = etNoteTitle.text.toString()
            var desc = etNoteDesc.text.toString()
            DataObject.setData(title, desc)

            GlobalScope.launch {
                database.dao().insertNote(NotesEntity(0,title,desc))
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}