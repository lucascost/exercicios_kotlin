package com.example.appsnct

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById(R.id.btnChamaTela)
        val rcvLista:RecyclerView = findViewById(R.id.rcvLista)
        btn.setOnClickListener(){
            val tela:Intent
            tela = Intent(this, FrmContato::class.java)
            startActivity(tela )
        }
    }

    override fun onResume() {
        super.onResume()
        rcvLista.adapter = PessoaAdapter(ListaPessoas)
        rcvLista.layoutMa
    }
}