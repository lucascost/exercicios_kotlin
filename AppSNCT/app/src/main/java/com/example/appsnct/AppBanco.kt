package com.example.appsnct

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [Pessoa::class],version = 1,exportSchema = false)

public abstract class AppBanco:RoomDatabase(){
    abstract fun pessoaDao():PessoaDAO
}