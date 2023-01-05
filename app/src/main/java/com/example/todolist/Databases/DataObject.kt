package com.example.todolist.Databases

object DataObject {
    var listdata = mutableListOf<NotesInfo>()

    fun setData(title: String, desc: String) {
        listdata.add(NotesInfo(title, desc))
    }

    fun getAllData(): List<NotesInfo> {
        return listdata
    }

    fun getData(pos:Int): NotesInfo {
        return listdata[pos]
    }

    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos:Int,title:String,desc:String)
    {
        listdata[pos].title=title
        listdata[pos].desc=desc
    }
}