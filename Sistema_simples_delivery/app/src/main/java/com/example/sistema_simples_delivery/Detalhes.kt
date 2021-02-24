package com.example.sistema_simples_delivery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sistema_simples_delivery.databinding.ActivityDetalhesBinding

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(b.root)
        //recuperaçao de dados
        val i_nome = intent.getStringExtra("item_nome")
        val preco_p = intent.getDoubleExtra("item_preco",0.0)
        val preco_m = intent.getDoubleExtra("item_preco_medio",0.0)
        val preco_g = intent.getDoubleExtra("item_preco_grande",0.0)
        var quantidade:Int = 1
        var preco:Double=0.0



        //Preenchimento
        b.img.setImageResource(intent.getIntExtra("item_preview",0))
        b.nome.text = i_nome
        b.descricao.text= intent.getStringExtra("item_descricao")
        b.precoP.text= "R$"+preco_p.toString()+"0"
        b.precoM.text= "R$"+preco_m.toString()+"0"
        b.precoG.text= "R$"+preco_g.toString()+"0"

        //Ações
        b.selecP.setOnClickListener(){ configButtons(b.selecP);preco = preco_p;changeCost(preco,quantidade,b.txtCusto) }
        b.selecM.setOnClickListener(){ configButtons(b.selecM);preco = preco_m;changeCost(preco,quantidade,b.txtCusto) }
        b.selecG.setOnClickListener(){ configButtons(b.selecG);preco = preco_g;changeCost(preco,quantidade,b.txtCusto) }

        b.btnMais.setOnClickListener(){quantidade++; b.txtQuantidade.text = quantidade.toString();changeCost(preco,quantidade,b.txtCusto)}
        b.btnMenos.setOnClickListener(){quantidade--; b.txtQuantidade.text = quantidade.toString();changeCost(preco,quantidade,b.txtCusto)}

        b.btConfirmar.setOnClickListener(){
            val intent = Intent(this,Final::class.java)
            intent.putExtra("final_nome",i_nome)
            intent.putExtra("final_quantidade",quantidade)
            intent.putExtra("final_preco",preco)
            startActivity(intent)
        }


    }
    fun configButtons( bt:Button){
        this.findViewById<Button>(R.id.selecP).setBackgroundColor( getResources().getColor(R.color.dark_green))
        this.findViewById<Button>(R.id.selecM).setBackgroundColor( getResources().getColor(R.color.dark_green))
        this.findViewById<Button>(R.id.selecG).setBackgroundColor( getResources().getColor(R.color.dark_green))
        bt.setBackgroundColor( getResources().getColor(R.color.orange))
    }
    fun changeCost(preco:Double,quant:Int,txt:TextView){
        txt.text="R$ "+(preco*quant).toString()+"0"
    }
}