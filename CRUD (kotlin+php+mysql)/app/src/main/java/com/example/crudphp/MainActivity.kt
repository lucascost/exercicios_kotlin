package com.example.crudphp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudphp.databinding.ActivityMainBinding
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion

class MainActivity : AppCompatActivity() {

    private val HOST = "http://10.0.0.105"

    lateinit var contatosAdapter:ContatosAdapter
    lateinit var lista:ArrayList<Contato>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val recycler = findViewById<RecyclerView>(R.id.recycler)


        val url = HOST+"/create.php"

        lista= ArrayList()
        listarContatos()
        contatosAdapter = ContatosAdapter(lista)
        recycler.adapter = contatosAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        

        b.btnSalvar.setOnClickListener() {
            var id: String = b.edtId.text.toString()
            var nome: String = b.edtNome.text.toString()
            var telefone: String = b.edtTelefone.text.toString()
            var email: String = b.edtEmail.text.toString()


            if (id.isEmpty()) {
                Ion.with(applicationContext)
                        .load(url)
                        .setBodyParameter("nome", nome)
                        .setBodyParameter("telefone", telefone)
                        .setBodyParameter("email", email)
                        .asJsonObject()
                        .setCallback { e, result ->

                            if (result.get("create").asString.equals("ok")) {

                                val idRetornado: Int = Integer.parseInt(result.get("ID").asString)
                                Toast.makeText(this, "Salvo com sucesso, id: "+idRetornado, Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                            }
                        }
            } //update

            listarContatos()
        }
    }
    fun listarContatos(){
         lista.clear()
        val url:String = HOST+"/read.php"
        Ion.with(baseContext).load(url).asJsonArray().setCallback { e, result:JsonArray ->
            for(i:Int in 0 .. result.size()-1){
                var obj:JsonObject = result.get(i).asJsonObject!!
                var c:Contato = Contato()
                c.id = obj.get("id").asInt
                c.nome = obj.get("nome").asString
                c.telefone = obj.get("telefone").asString
                c.email = obj.get("email").asString

                lista.add(c)
            }
            contatosAdapter.notifyDataSetChanged()
        }
    }
}