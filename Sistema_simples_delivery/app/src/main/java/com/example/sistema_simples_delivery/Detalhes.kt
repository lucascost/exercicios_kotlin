package com.example.sistema_simples_delivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_simples_delivery.databinding.ActivityDetalhesBinding

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.img.setImageResource(intent.getIntExtra("item_preview",0))
        b.nome.text = intent.getStringExtra("item_nome")
        b.descricao.text= intent.getStringExtra("item_descricao")


    }
}