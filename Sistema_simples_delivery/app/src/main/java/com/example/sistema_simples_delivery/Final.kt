package com.example.sistema_simples_delivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_simples_delivery.databinding.ActivityFinalBinding

class Final : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val e = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(e.root)

        val line = ".................................................................."

        val final_preco =intent.getDoubleExtra("final_preco",0.0)
        val final_quantidade = intent.getIntExtra("final_quantidade",0)
        val final_total = final_preco*final_quantidade+4.0

        e.tvNome.text = "Pizza "+intent.getStringExtra("final_nome")
        e.tvQuantidade.text =final_quantidade.toString()+" x "+final_preco.toString()+line
        e.tvPreco.text = "R$"+(final_preco*final_quantidade).toString()+"0"
        e.tvTotal.text = "R$"+final_total.toString()+"0"

    }
}