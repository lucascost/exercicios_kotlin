package com.example.crudphp

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

        val url = HOST+"/create.php"
        var itemClicado:Int=0

        lista= ArrayList()
        atualizarLista()

        contatosAdapter = ContatosAdapter(lista)
        b.recycler.adapter = contatosAdapter
        b.recycler.layoutManager = LinearLayoutManager(this)

        b.btnAdd.setOnClickListener() {
            if(camposPreenchidos(b.edtNome,b.edtTelefone,b.edtEmail)){
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
                }//update
            } else
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            limparCampos(b.edtId,b.edtNome,b.edtTelefone,b.edtEmail)
            atualizarLista()
        }

        b.recycler.addOnItemTouchListener(RecyclerItemClickListener(this) { view, position ->
            Toast.makeText(this, "Item "+position+" selecionado", Toast.LENGTH_SHORT).show()
            itemClicado=position
            //preencher campos
            var aux:Contato = lista[itemClicado]
            b.edtId.setText(aux.id.toString())
            b.edtNome.setText(aux.nome)
            b.edtTelefone.setText(aux.telefone)
            b.edtEmail.setText(aux.email)

        })

        b.btnSalvar.setOnClickListener(){
            var aux = Contato()
            aux.id=lista[itemClicado].id
            aux.nome= b.edtNome.text.toString()
            aux.telefone= b.edtTelefone.text.toString()
            aux.email= b.edtEmail.text.toString()
            Ion.with(applicationContext)
                    .load("http://10.0.0.105/update.php")
                    .setBodyParameter("nome", aux.nome)
                    .setBodyParameter("telefone", aux.telefone)
                    .setBodyParameter("email", aux.email)
                    .setBodyParameter("id", aux.id.toString())
                    .asJsonObject()
                    .setCallback { e, result ->

                        if (result.get("update").asString.equals("ok")) {
                            Toast.makeText(this, "Atualizado com sucesso", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                        }
                    }
            atualizarLista()
            limparCampos(b.edtId,b.edtNome,b.edtTelefone,b.edtEmail)
        }

        b.btnExcluir.setOnClickListener(){
            var aux = Contato()
            aux.id=lista[itemClicado].id
            Ion.with(applicationContext)
                    .load("http://10.0.0.105/delete.php")
                    .setBodyParameter("id", aux.id.toString())
                    .asJsonObject()
                    .setCallback { e, result ->

                        if (result.get("delete").asString.equals("ok")) {
                            Toast.makeText(this, "Deletado com sucesso", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                        }
                    }
            atualizarLista()
            limparCampos(b.edtId,b.edtNome,b.edtTelefone,b.edtEmail)
        }
    }

    fun atualizarLista(){
        lista.clear()
        val url:String = HOST+"/read.php"
        Ion.with(baseContext).load(url).asJsonArray().setCallback { e, result:JsonArray ->
            for(i:Int in 0 .. result.size()-1){
                var obj:JsonObject = result.get(i).asJsonObject!!
                var c = Contato()
                c.id = obj.get("id").asInt
                c.nome = obj.get("nome").asString
                c.telefone = obj.get("telefone").asString
                c.email = obj.get("email").asString

                lista.add(c)
                contatosAdapter.notifyDataSetChanged()
            }

        }
    }

    fun camposPreenchidos(nome:EditText,telefone:EditText,email:EditText): Boolean {
        return !(nome.text.isNullOrEmpty() || telefone.text.isNullOrEmpty()||(email.text.isNullOrEmpty()))
    }
    fun limparCampos(id:EditText,nome:EditText,telefone:EditText,email:EditText){
        id.setText("")
        nome.setText("")
        telefone.setText("")
        email.setText("")
    }
}