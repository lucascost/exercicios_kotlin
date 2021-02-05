package com.example.frasedodia

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    val frases = arrayOf(
        "Olhe pra cima, que é de lá que vem tua força!",
        "Agora é hora de começar a surpreender aqueles que duvidaram de voce!",
        "Você nunca será velho demais para sonhar um novo sonho.",
        "Quando pensar em desistir, lembre-se porque começou."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txtFrase)
    }

    fun gerarFrase(view: View){
        val totalItens = frases.size
        val numero = Random().nextInt(totalItens)
        texto.text = frases[numero]
    }

}