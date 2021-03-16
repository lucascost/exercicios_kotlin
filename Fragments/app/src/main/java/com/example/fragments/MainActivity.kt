package com.example.fragments


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(home_fragment())

        this.findViewById<Button>(R.id.button).setOnClickListener(){
            setFragment(home_fragment())
        }
        this.findViewById<Button>(R.id.button2).setOnClickListener(){
            setFragment(second_fragment())
        }
        this.findViewById<Button>(R.id.button3).setOnClickListener(){
            setFragment(third_fragment())
        }
    }
    private fun setFragment(fragment:Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_content,fragment)
            .commit()
    }
}