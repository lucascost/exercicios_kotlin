package com.example.fragments


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        this.findViewById<Button>(R.id.button2).setOnClickListener(){
            val newFragment = MainFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_content, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        this.findViewById<Button>(R.id.button3).setOnClickListener(){
            val newFragment = SecondFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_content, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}