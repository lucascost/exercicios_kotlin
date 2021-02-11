package com.example.appsnct

import androidx.room.*

@Dao
interface PessoaDAO {
    @Insert
    fun inserirPessoa(pessoa: Pessoa)
    @Delete
    fun deletePessoa(pessoa: Pessoa)
    @Update
    fun updatePessoa(pessoa: Pessoa)
    @Query ("select * from Pessoa")
    fun listarPessoas():List<Pessoa>
    @Query("select * from Pessoa where idpessoa=:id")
    fun getPessoa(id:Int):Pessoa
}