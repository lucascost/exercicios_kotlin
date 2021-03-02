package com.example.notas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(var lista:List<Nota>):RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val txtView = itemView.findViewById<TextView>(R.id.textView)
        //val layout = itemView.findViewById<LinearLayout>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.note_row,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val n = lista[position]
        holder.txtView.text = n.note_text
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}