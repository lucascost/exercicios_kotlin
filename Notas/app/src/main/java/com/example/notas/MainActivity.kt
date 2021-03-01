package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room


class MainActivity : AppCompatActivity() {
    lateinit var nota_atual:Nota

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: DBase = Room.databaseBuilder(applicationContext, DBase::class.java, "banco")
            .allowMainThreadQueries().build()
        val notas: List<Nota> = db.noteDao().listar()

        var acao = 1 //1-salvar 2-editar 3-excluir
        var id = 0

        val rcv = findViewById<RecyclerView>(R.id.recycler)
        val edt = findViewById<EditText>(R.id.edtText)
        val btn = findViewById<Button>(R.id.button)

        rcv.adapter = NoteAdapter(notas)
        rcv.layoutManager = LinearLayoutManager(this)




        rcv.addOnItemTouchListener(RecyclerItemClickListener(this) { view, position ->
            mudaTexto(edt, db,position)
            acao=2
            id = position+1
            btn.setText("Salvar")
        })

        btn.setOnClickListener() {
            if(acao==1) {
                nota_atual = Nota()
                nota_atual.note_text = edt.text.toString()
                db.noteDao().inserir(nota_atual)
            }
            else{
                nota_atual= db.noteDao().procurar(id)
                nota_atual.note_text= edt.text.toString()
                db.noteDao().editar(nota_atual)
            }
            edt.setText("")
            this.recreate();

        }
    }
    fun mudaTexto(edt: EditText, db: DBase,pos:Int){
        val n = db.noteDao().procurar(pos+1)
        edt.setText(n.note_text)
    }
}