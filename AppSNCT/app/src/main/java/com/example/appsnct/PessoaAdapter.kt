package com.example.appsnct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter (var lista:ArrayList<Pessoa>):RecyclerView.Adapter<PessoaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View
        v = LayoutInflater.from(parent?.context).inflate(R.layout.item_contato,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objeto = lista[position]
        holder?.txtNome.text = objeto.nome.toString()
        holder?.txtEmail.text = objeto.email.toString()
        holder?.txtTelefone.text = objeto.telefone.toString()
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
        val txtNome = itemView.findViewById<TextView>(R.id.txtNomePessoa)
        val txtEmail = itemView.findViewById<TextView>(R.id.txtEmailPessoa)
        val txtTelefone = itemView.findViewById<TextView>(R.id.txtNomePessoa)

    }

}