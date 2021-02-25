package com.example.notas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 class Nota {
    @PrimaryKey(autoGenerate = true) var noteId:Int=0
    @ColumnInfo(name = "text") var note_text:String?=null
}