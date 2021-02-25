package com.example.notas

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Nota::class],version = 1)
abstract class DBase:RoomDatabase() {
    abstract fun noteDao():NoteDAO
}