package com.example.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(home_fragment())

        val bottonNavHome = findViewById<BottomNavigationItemView>(R.id.menu_home)
        val bottonNavSec = findViewById<BottomNavigationItemView>(R.id.menu_second)
        val bottonNavThird = findViewById<BottomNavigationItemView>(R.id.menu_third)

        bottonNavHome.setOnClickListener(){ setFragment(home_fragment()) }
        bottonNavSec.setOnClickListener() { setFragment(second_fragment()) }
        bottonNavThird.setOnClickListener(){ setFragment(third_fragment()) }

    }
    private fun setFragment(fragment:Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_content,fragment)
            .commit()
    }
}