package com.example.sistema_simples_delivery

class produto(val preview:Int, val nome:String,val descricao:String, val preco:Double,val precoMedio:Double,val precoGrande:Double ){

}

val produtos = ArrayList<produto>()

val frango = produto(
     R.drawable.frango_com_catupiry,
    "Frango com Catupiry",
    "Molho, mussarela, frango desfiado, catupiry e orégano.",
    25.90,
    39.90,
    56.90)

val mussarela = produto(
    R.drawable.mussarela,
    "Mussarela",
    "Molho, mussarela, tomate em rodelas e orégano.",
    24.90,
    35.90,
    46.90)

val calabresa = produto(
    R.drawable.calabresa,
    "Calabresa",
    "Molho, mussarela, calabresa, cebola fatiada e orégano..",
    24.90,
    36.90,
    46.90)

val margherita = produto(
    R.drawable.margherita,
    "Margherita",
    "Molho, mussarela, tomates em rodelas e manjericão.",
    24.90,
    35.90,
    46.90)

val basca = produto(
    R.drawable.basca,
    "Basca",
    "Molho, mussarela, bacon, rodelas de tomates, catupiry e orégano.",
    24.90,
    35.90,
    46.90)

val portuguesa = produto(
    R.drawable.portuguesa,
    "Portuguesa",
    "Molho, mussarela, bacon, rodelas de tomates, catupiry e orégano.",
    25.90,
    39.90,
    56.90)