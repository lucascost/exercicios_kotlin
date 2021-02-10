package com.example.appsnct

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FrmContato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frm_contato)

        val btnAcao:Button = findViewById(R.id.btnAcao)
        val edtNome:EditText = findViewById(R.id.edtNome)
        val edtEmail:EditText = findViewById(R.id.edtEmail)
        val edtTelefone:EditText = findViewById(R.id.edtTelefone)
        val edtSalario:EditText = findViewById(R.id.edtSalario)
        val acao = intent.getStringExtra("ACAO")
        val pos = intent.getIntExtra("POSICAO",0) as Int

        if(pos != -1){
            val vcontato = ListaPessoas[pos]
            edtNome.setText(vcontato.nome.toString())
            edtEmail.setText(vcontato.email.toString())
            edtTelefone.setText(vcontato.telefone.toString())
            edtSalario.setText(vcontato.salario.toString())

            if(acao.equals("excluir")){
                btnAcao.setText("Excluir")
                btnAcao.setOnClickListener() {
                    ListaPessoas.removeAt(pos)
                    finish()
                }
            }else if(acao.equals("editar")){
                btnAcao.setText("Salvar")
                btnAcao.setOnClickListener(){
                    var nome:String=""
                    var email:String=""
                    var telefone:String=""
                    var salario:Double = 0.0

                    if(edtNome.text.isNullOrEmpty()) { edtNome.error="Digite o nome!"}
                    else { nome = edtNome.text.toString()}

                    if(edtEmail.text.isNullOrEmpty()) {  edtEmail.error="Digite o email!"}
                    else {  email = edtEmail.text.toString()}

                    if(edtTelefone.text.isNullOrEmpty()) {  edtTelefone.error="Digite o telefone!"}
                    else {  telefone = edtTelefone.text.toString()}

                    if(edtSalario.text.isNullOrEmpty()) {  edtSalario.error="Digite o salário!"}
                    else {  salario = edtSalario.text.toString().toDouble()}

                    val novaPessoa = Pessoa(nome,telefone,email,salario)
                    ListaPessoas.set(pos,novaPessoa)
                    Toast.makeText(this, "Dados de ${novaPessoa.nome} salvos com sucesso!", Toast.LENGTH_SHORT).show()
                        finish()
                }
            }

        } else {
            btnAcao.setOnClickListener(){
                var nome:String=""
                var email:String=""
                var telefone:String=""
                var salario:Double = 0.0

                if(edtNome.text.isNullOrEmpty()) { edtNome.error="Digite o nome!"}
                else { nome = edtNome.text.toString()}

                if(edtEmail.text.isNullOrEmpty()) {  edtEmail.error="Digite o email!"}
                else {  email = edtEmail.text.toString()}

                if(edtTelefone.text.isNullOrEmpty()) {  edtTelefone.error="Digite o telefone!"}
                else {  telefone = edtTelefone.text.toString()}

                if(edtSalario.text.isNullOrEmpty()) {  edtSalario.error="Digite o salário!"}
                else {  salario = edtSalario.text.toString().toDouble()}

                val novaPessoa = Pessoa(nome,telefone,email,salario)

                if(ListaPessoas.add(novaPessoa)){
                    Toast.makeText(this, "Dados de ${novaPessoa.nome} salvos com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

}


