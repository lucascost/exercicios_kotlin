package com.example.crudphp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ContatosAdapter(ctx2:Context, lista2:List<Contato> ):BaseAdapter() {

    var ctx:Context = ctx2
    var lista:List<Contato> = lista2

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Contato {
        return lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v:View

        if(convertView==null) run {
            var inflater: LayoutInflater = (Activity()).layoutInflater
            v= inflater.inflate(R.layout.item_lista, null)
        } else {
            v=convertView
        }

        var c:Contato = getItem(position)

        var itemNome = v.findViewById<TextView>(R.id.itemNome)
        var itemTelefone = v.findViewById<TextView>(R.id.itemTelefone)
        var itemEmail = v.findViewById<TextView>(R.id.itemEmail)

        itemNome.text = c.nome
        itemTelefone.text = c.telefone
        itemEmail.text = c.email

        return v
    }
}