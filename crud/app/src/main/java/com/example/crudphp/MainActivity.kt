package com.example.crudphp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crudphp.databinding.ActivityMainBinding
import com.koushikdutta.ion.Ion

class MainActivity : AppCompatActivity() {

    private val HOST = "http://10.0.0.105"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        val url = HOST+"/create.php"

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


        }
    }
}