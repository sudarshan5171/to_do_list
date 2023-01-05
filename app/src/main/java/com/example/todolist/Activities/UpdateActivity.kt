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
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.etNoteDesc
import kotlinx.android.synthetic.main.activity_update.etNoteTitle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "NotesTable"
        ).build()

        val pos = intent.getIntExtra("id",-1)

        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val desc = DataObject.getData(pos).desc
            etNoteTitle.setText(title)
            etNoteDesc.setText(desc)

            btnDelete.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteNote(
                        NotesEntity(
                            pos + 1,
                            etNoteTitle.text.toString(),
                            etNoteDesc.text.toString()
                        )
                    )
                }
                myIntent()
            }
        }

        btnUpdate.setOnClickListener(View.OnClickListener {
            DataObject.updateData(
                pos,
                etNoteTitle.text.toString(),
                etNoteDesc.text.toString()
            )
            GlobalScope.launch {
                database.dao().updateNote(
                    NotesEntity(
                        pos + 1, etNoteTitle.text.toString(),
                        etNoteDesc.text.toString()
                    )
                )
            }
            myIntent()
        })
    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}