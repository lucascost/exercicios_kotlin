package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: DBase = Room.databaseBuilder(applicationContext, DBase::class.java, "banco")
            .allowMainThreadQueries().build()
        val notas: List<Nota> = db.noteDao().listar()

        val rcv = findViewById<RecyclerView>(R.id.recycler)
        rcv.adapter = NoteAdapter(notas)
        rcv.layoutManager = LinearLayoutManager(this)

        this.findViewById<Button>(R.id.button).setOnClickListener() {
            val n = Nota()
            val edt = findViewById<EditText>(R.id.edtText)
            n.note_text = edt.text.toString()
            db.noteDao().inserir(n)
            edt.setText("")
            this.recreate();

        }
    }
}