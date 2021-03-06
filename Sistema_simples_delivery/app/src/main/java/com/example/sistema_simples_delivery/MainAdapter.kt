package com.example.sistema_simples_delivery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (var lista: ArrayList<produto>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val img_preview = itemView.findViewById<ImageView>(R.id.img_preview)
        val txtNome = itemView.findViewById<TextView>(R.id.txt_nome)
        val txtDescricao = itemView.findViewById<TextView>(R.id.txt_descricao)
        val txtPreco = itemView.findViewById<TextView>(R.id.txt_preco)
        val layout = itemView.findViewById<ConstraintLayout>(R.id.layout_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = lista[position]
        holder.img_preview.setImageResource(produto.preview)
        holder.txtNome.text = produto.nome
        holder.txtDescricao.text = produto.descricao
        holder.txtPreco.text = ("R$"+produto.preco.toString()+"0")

        holder.layout.setOnClickListener(){
            val intent = Intent(holder.itemView.context,Detalhes::class.java)
            intent.putExtra("item_preview", produto.preview)
            intent.putExtra("item_nome",produto.nome)
            intent.putExtra("item_descricao",produto.descricao)
            intent.putExtra("item_preco",produto.preco)
            intent.putExtra("item_preco_medio",produto.precoMedio)
            intent.putExtra("item_preco_grande",produto.precoGrande)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}