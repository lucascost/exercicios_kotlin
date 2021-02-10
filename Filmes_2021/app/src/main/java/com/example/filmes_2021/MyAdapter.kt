package com.example.filmes_2021

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItens(model: Model) {
            itemView.findViewById<TextView>(R.id.txt_titulo).text = model.title
            itemView.findViewById<TextView>(R.id.txt_info).text = model.info
            itemView.findViewById<ImageView>(R.id.img_capa).setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.row,parent,false) //context deveria ser parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItens(arrayList[position])
        holder.itemView.setOnClickListener(){
            currentItem=position
            val intent = Intent(context, Detalhes::class.java).apply {
                putExtra(EXTRA_TITLE, arrayList[position].title)
                putExtra(EXTRA_DESCRIPTION, arrayList[position].desc)
                //putExtra(EXTRA_IMAGE, arrayList[position].image)
            }
            this.context.startActivity(intent)
    }}

    override fun getItemCount(): Int {
        return arrayList.size
    }
}