package com.marcrubio.practicaslayoutpropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preu: EditText = findViewById(R.id.cost_of_service)
        val butonCalculate: Button = findViewById(R.id.calculate_button)
        val radio20: RadioButton = findViewById(R.id.option_twenty_percent)
        val radio18: RadioButton = findViewById(R.id.option_eighteen_percent)
        val radio15: RadioButton = findViewById(R.id.option_fifteen_percent)
        val switchRound: Switch = findViewById(R.id.round_up_switch)
        val resualr: TextView = findViewById(R.id.tip_result)

        butonCalculate.setOnClickListener {
            val preuText = preu.text.toString()

            if (preuText.isNotEmpty()) {
                val preuValue = preuText.toFloat()
                var tipPercentage = 0.0

                when {
                    radio20.isChecked -> tipPercentage = 0.20
                    radio18.isChecked -> tipPercentage = 0.18
                    radio15.isChecked -> tipPercentage = 0.15
                }

                val tipAmount = preuValue * tipPercentage

                if (switchRound.isChecked) {
                    val roundedTipAmount = Math.round(tipAmount)
                    resualr.text = "Propina: $roundedTipAmount"
                } else {
                    resualr.text = "Propina: $tipAmount"
                }

            } else {
                Toast.makeText(this, "Ingresa un valor ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}