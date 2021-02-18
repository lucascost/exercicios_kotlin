package com.example.appsnct

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.appsnct.databinding.ActivityFrmContatoBinding

class FrmContato : AppCompatActivity() {


    lateinit var banco: AppBanco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityFrmContatoBinding= ActivityFrmContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        banco = Room.databaseBuilder(this, AppBanco::class.java,"pessoas")
            .allowMainThreadQueries().build()
        //declarações
        val edtNome = binding.edtNome
        val edtEmail = binding.edtEmail
        val edtTelefone = binding.edtTelefone
        val edtSalario = binding.edtSalario

        val acao = intent.getStringExtra("ACAO")
        val pos = intent.getIntExtra("POSICAO",0)

        if(pos != -1){
            val vcontato = banco.pessoaDao().getPessoa(pos)
            preencheCampos(binding, vcontato)

            if(acao.equals("excluir")){
                excluir(binding,vcontato)
            }
            else if(acao.equals("editar")){
                    editar(binding,pos,edtNome,edtEmail,edtTelefone,edtSalario )
            }
        }
        else { //NOVO CADASTRO
                cadastrar(binding,edtNome,edtEmail,edtTelefone,edtSalario)
        }
    }


    fun cadastrar(binding: ActivityFrmContatoBinding,edtNome:EditText, edtEmail:EditText, edtTelefone:EditText, edtSalario:EditText){
        binding.btnAcao.setOnClickListener(){
            if(validaCampo(edtNome)&&
                    validaCampo(edtEmail)&&
                    validaCampo(edtTelefone)&&
                    validaCampo(edtSalario)){
                val novaPessoa = Pessoa()
                novaPessoa.nome = edtNome.text.toString()
                novaPessoa.email = edtEmail.text.toString()
                novaPessoa.telefone = edtTelefone.text.toString()
                novaPessoa.salario = edtSalario.text.toString().toDouble()

                try{
                    banco.pessoaDao().inserirPessoa(novaPessoa)
                } catch(e:Exception){
                    Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
                } finally {
                    Toast.makeText(this, "Dados de ${novaPessoa.nome} salvos com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
    fun excluir(binding: ActivityFrmContatoBinding,vcontato:Pessoa){
        binding.btnAcao.setText("Excluir")
        binding.btnAcao.setOnClickListener() {
            banco.pessoaDao().deletePessoa(vcontato)
            finish() }
    }
    fun editar(binding: ActivityFrmContatoBinding,pos:Int,edtNome:EditText, edtEmail:EditText, edtTelefone:EditText, edtSalario:EditText) {
        binding.btnAcao.setText("Salvar")
        binding.btnAcao.setOnClickListener() {
            if (validaCampo(edtNome)
                    && validaCampo(edtEmail)
                    && validaCampo(edtTelefone)
                    && validaCampo(edtSalario)) {

                val novaPessoa = Pessoa()
                novaPessoa.nome = edtNome.text.toString()
                novaPessoa.email = edtEmail.text.toString()
                novaPessoa.telefone = edtTelefone.text.toString()
                novaPessoa.salario = edtSalario.text.toString().toDouble()
                novaPessoa.idpessoa = pos

                try {
                    banco.pessoaDao().updatePessoa(novaPessoa)
                } catch (e: Exception) {
                    Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
                } finally {
                    Toast.makeText(this, "Dados de ${novaPessoa.nome} salvos com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
    fun preencheCampos(binding:ActivityFrmContatoBinding, vcontato:Pessoa){
        binding.edtNome.setText(vcontato.nome.toString())
        binding.edtEmail.setText(vcontato.email.toString())
        binding.edtTelefone.setText(vcontato.telefone.toString())
        binding.edtSalario.setText(vcontato.salario.toString())
    }
    fun validaCampo(campo:EditText):Boolean{
        if(campo.text.isNullOrEmpty()) { campo.error="Informação necessária!"}
        return !campo.text.isNullOrEmpty()





        /*
        if(edtNome.text.isNullOrEmpty()) { edtNome.error="Digite o nome!"}
        else { nome = edtNome.text.toString()}

        if(edtEmail.text.isNullOrEmpty()) {  edtEmail.error="Digite o email!"}
        else {  email = edtEmail.text.toString()}

        if(edtTelefone.text.isNullOrEmpty()) {  edtTelefone.error="Digite o telefone!"}
        else {  telefone = edtTelefone.text.toString()}

        if(edtSalario.text.isNullOrEmpty()) {  edtSalario.error="Digite o salário!"}
        else {  salario = edtSalario.text.toString().toDouble()}   */
    }

}


