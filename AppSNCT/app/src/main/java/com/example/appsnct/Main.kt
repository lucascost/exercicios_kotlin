package com.example.appsnct

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class Main : AppCompatActivity() {

    lateinit var lista:List<Pessoa>
    lateinit var banco: AppBanco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById(R.id.btnChamaTela)

        banco = Room.databaseBuilder(this, AppBanco::class.java,"pessoas")
            .allowMainThreadQueries().build()

        btn.setOnClickListener(){
            val tela:Intent
            tela = Intent(this, FrmContato::class.java)
            tela.putExtra("ACAO", "cadastrar")
            tela.putExtra("POSICAO", -1)
            startActivity(tela)
        }
    }

    override fun onResume() {
        super.onResume()
        lista = banco.pessoaDao().listarPessoas()
        val rcvLista:RecyclerView = findViewById(R.id.rcvLista)
        rcvLista.adapter = PessoaAdapter(lista)
        rcvLista.layoutManager = LinearLayoutManager(this)
    }
}