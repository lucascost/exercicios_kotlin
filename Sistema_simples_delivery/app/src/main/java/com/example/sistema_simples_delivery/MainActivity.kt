package com.example.sistema_simples_delivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistema_simples_delivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        produtos.add(brigadeiro)
        binding.recycler.adapter = MainAdapter(produtos)
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }
}