package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db: DBase = Room.databaseBuilder(applicationContext, DBase::class.java, "banco")
                .allowMainThreadQueries().build()
        var notas: List<Nota> = db.noteDao().listar()
        var acao = 1
        var nota_atual:Nota = Nota()

        val rcv = findViewById<RecyclerView>(R.id.recycler)
        val edt = findViewById<EditText>(R.id.edtText)
        val btn = findViewById<Button>(R.id.button)
        val btnDel = findViewById<Button>(R.id.button2)
            btnDel.isVisible=false


        rcv.adapter = NoteAdapter(notas)
        rcv.layoutManager = LinearLayoutManager(this)


        rcv.addOnItemTouchListener(RecyclerItemClickListener(this) { view, position ->
            nota_atual=notas[position]
            edt.setText(nota_atual.note_text)
            btn.text="Salvar"
            acao=2
            btnDel.isVisible=true
        })

        btn.setOnClickListener() {
                if(!edt.text.isNullOrEmpty()){
                    nota_atual.note_text=edt.text.toString()

                    if(acao==1){
                        db.noteDao().inserir(nota_atual)
                        this.recreate()
                    }
                    else
                        db.noteDao().editar(nota_atual)
                } else {
                    edt.error="campo vazio."
                }
            rcv.adapter?.notifyDataSetChanged()
            nota_atual=Nota()
            acao=1
            edt.setText("")
            btn.text="Adicionar"
            btnDel.isVisible=false
        }
        btnDel.setOnClickListener(){
            db.noteDao().remover(nota_atual)
            edt.setText("")
            this.recreate()
        }


    }
}