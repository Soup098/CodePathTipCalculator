package com.codepath.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var priceView: EditText
    lateinit var percentView: EditText
    lateinit var tipView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        priceView = findViewById<EditText>(R.id.price)
        percentView = findViewById<EditText>(R.id.percentage)
        tipView = findViewById<TextView>(R.id.tip)
    }


    fun buttonClick(view: View?){
        val tipAmount: Float
        val price: Float
        val percent: Float

        price = (priceView.text.toString()).toFloat()
        percent = (percentView.text.toString()).toFloat()

        tipAmount = price * (percent/100)

        println("The price is: " + price)
        println("The percent is: " + percent)
        println("The tip should be: " + tipAmount)

        tipView.text = "$" + tipAmount.toString()
    }
}