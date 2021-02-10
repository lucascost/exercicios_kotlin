package com.example.filmes_2021

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val txtTitle = intent.getStringExtra(EXTRA_TITLE)
        val txtDescricao = intent.getStringExtra(EXTRA_DESCRIPTION)

        val capa = findViewById<ImageView>(R.id.capa)
        val descricao = findViewById<TextView>(R.id.descricao)

        getSupportActionBar()?.setTitle(txtTitle)

        when(currentItem){
            0-> capa.setImageResource(R.drawable.um_lugar_silencioso)
            1-> capa.setImageResource(R.drawable.viuva_capa)
            2-> capa.setImageResource(R.drawable.supernova)
            3-> capa.setImageResource(R.drawable.raya)
            4-> capa.setImageResource(R.drawable.invoca_ao)
            5-> capa.setImageResource(R.drawable.minions2)
            else-> capa.setImageResource(R.drawable.dune_2020)
        }
        descricao.text=txtDescricao
    }
}