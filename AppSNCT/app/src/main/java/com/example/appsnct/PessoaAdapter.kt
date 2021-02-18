package com.example.appsnct

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class PessoaAdapter (var lista:List<Pessoa>):RecyclerView.Adapter<PessoaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View
        v = LayoutInflater.from(parent.context).inflate(R.layout.item_contato,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objeto = lista[position]
        holder?.txtTelefone.text = objeto.telefone.toString()
        holder?.txtEmail.text = objeto.email.toString()
        holder?.txtNome.text = objeto.nome.toString()
        holder?.txtSalario.text = NumberFormat.getCurrencyInstance().format(objeto.salario.toString().toDouble())
        holder?.btnExcluir.setOnClickListener(){
            val intencao = Intent(holder?.itemView.context, FrmContato::class.java)
            intencao.putExtra("ACAO", "excluir")
            intencao.putExtra("POSICAO", objeto.idpessoa)
            holder.itemView.context.startActivity(intencao)
        }
        holder?.btnEditar.setOnClickListener(){
            val intencao = Intent(holder?.itemView.context, FrmContato::class.java)
            intencao.putExtra("ACAO", "editar")
            intencao.putExtra("POSICAO", objeto.idpessoa)
            holder.itemView.context.startActivity(intencao)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
        val txtNome = itemView.findViewById<TextView>(R.id.txtNomePessoa)
        val txtEmail = itemView.findViewById<TextView>(R.id.txtEmailPessoa)
        val txtTelefone = itemView.findViewById<TextView>(R.id.txtTelefonePessoa)
        val btnEditar = itemView.findViewById<ImageView>(R.id.btnEditarContato)
        val btnExcluir = itemView.findViewById<ImageView>(R.id.btnExcluirContato)
        val txtSalario = itemView.findViewById<TextView>(R.id.txtSalarioPessoa)

    }

}