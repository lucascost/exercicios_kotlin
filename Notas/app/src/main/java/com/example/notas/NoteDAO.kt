package com.example.notas

import androidx.room.*

@Dao
interface NoteDAO {
    @Insert
    fun inserir(nota:Nota)
    @Delete
    fun remover(nota:Nota)
    @Update
    fun editar(nota:Nota)
    @Query("select * from Nota")
    fun listar():List<Nota>
    @Query("select * from Nota where noteId =:id ")
    fun procurar(id:Int):Nota
}