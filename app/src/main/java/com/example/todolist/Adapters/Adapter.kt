package com.example.todolist.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Activities.UpdateActivity
import com.example.todolist.Databases.NotesInfo
import com.example.todolist.R
import kotlinx.android.synthetic.main.listitem.view.*

class Adapter(var data: List<NotesInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.tvNoteTitle
        var desc = itemView.tvNoteDesc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.desc.text = data[position].desc

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java)
            intent.putExtra("id",position)  //send id to next activity for putting values in EditText
            holder.itemView.context.startActivity(intent) //context.startActivity
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }

}