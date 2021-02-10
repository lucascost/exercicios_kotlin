package com.example.filmes_2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
const val EXTRA_TITLE = "com.example.filmes_2021.TITLE"
const val EXTRA_DESCRIPTION = "com.example.filmes_2021.DESCRIPTION"
//const val EXTRA_IMAGE = "com.example.filmes_2021.IMAGE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayList = ArrayList<Model>()

        //teste


        getSupportActionBar()?.setTitle("Lançamentos 2021")
        arrayList.add(Model("Um Lugar Silencioso", "08/03 ‧ Terror/Thriller ‧ 1h 40m", R.drawable.um_lugar_silencioso,
            desc_um_lugar))
        arrayList.add(Model("Viúva Negra", "29/04 ‧ Ação/Aventura ‧ 2h 13m", R.drawable.viuva_capa,
            desc_viuva))
        arrayList.add(Model("Supernova", "29/01 ‧ Drama/Romance ‧ 1h 35m", R.drawable.supernova,
            desc_supernova))
        arrayList.add(Model("Raya e o Último Dragão", "04/03 ‧ Fantasia/Aventura", R.drawable.raya,
            desc_raya))
        arrayList.add(Model("Invocação do Mal 3", "10/09 ‧ Terror/Terror sobrenatural", R.drawable.invoca_ao,
            desc_invocacao))
        arrayList.add(Model("Minions 2", "17/06 ‧ Comédia/Animação ‧ 1h 30m", R.drawable.minions2,
            desc_minions2))
        arrayList.add(Model("Duna", "01/10 ‧ Ficção científica/Aventura", R.drawable.dune_2020,
            desc_duna))



        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.adapter = MyAdapter(arrayList,this)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}