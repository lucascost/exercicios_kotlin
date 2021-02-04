package com.example.tipcalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCalculate: Button = findViewById(R.id.btn_calculate)
        btnCalculate.setOnClickListener(){ calculate() }
    }
    fun calculate(){
        val edtCost:EditText = findViewById(R.id.cost_of_service)
        val tip_options:RadioGroup = findViewById(R.id.tip_options)
        val roundTip:Switch = findViewById(R.id.round_tip)
        val text_result:TextView = findViewById(R.id.text_result)
        var cost_text:String = edtCost.text.toString()

        if(!cost_text.equals("")){
            var cost:Double = cost_text.toDouble()
            var tip_percent:Double = when(tip_options.checkedRadioButtonId){
                R.id.option_15->0.15
                R.id.option_18->0.18
                else ->0.20
            }
            var tip_value = cost*tip_percent
            if(roundTip.isChecked)
                tip_value=kotlin.math.ceil(tip_value)
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip_value)
            text_result.text=formattedTip
        } else
            Toast.makeText(this,"Please, insert the cost of service", Toast.LENGTH_LONG).show()
    }
}