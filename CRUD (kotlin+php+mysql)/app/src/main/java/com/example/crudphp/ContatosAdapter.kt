package com.example.crudphp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatosAdapter(var lista:List<Contato>):RecyclerView.Adapter<ContatosAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txtNome = itemView.findViewById<TextView>(R.id.itemNome)
        val txtTelefone = itemView.findViewById<TextView>(R.id.itemTelefone)
        val txtEmail = itemView.findViewById<TextView>(R.id.itemEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View
        v=LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ct=lista[position]
        holder.txtNome.text=ct.nome
        holder.txtTelefone.text=ct.telefone
        holder.txtEmail.text=ct.email
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}
