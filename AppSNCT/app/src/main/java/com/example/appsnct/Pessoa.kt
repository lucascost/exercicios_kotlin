package com.example.appsnct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pessoa {
    @PrimaryKey(autoGenerate = true)
    var idpessoa:Int?=null
    @ColumnInfo(name = "p_nome")
    var nome:String?=null
    @ColumnInfo(name = "p_telefone")
    var telefone:String?=null
    @ColumnInfo(name = "p_email")
    var email:String?=null
    @ColumnInfo(name = "p_salario")
    var salario:Double?=0.0
}
