package com.example.todolist.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.Adapters.Adapter
import com.example.todolist.Databases.DataObject
import com.example.todolist.R
import kotlinx.android.synthetic.main.activity_main.*

//entity - table
//dao - queries

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNoteBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        })

        recyclerView.adapter = Adapter(DataObject.getAllData())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}