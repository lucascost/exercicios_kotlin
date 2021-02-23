package com.example.sistema_simples_delivery

class produto(val preview:Int, val nome:String,val descricao:String, val preco:Double, ){
    val quantidade:Int=0
    val total:Double=0.0
}

val produtos = ArrayList<produto>()

val brigadeiro = produto(
     R.drawable.ic_launcher_foreground,
    "Nome",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    0.0 )