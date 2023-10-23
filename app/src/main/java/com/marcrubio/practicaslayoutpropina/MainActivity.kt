package com.marcrubio.practicaslayoutpropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.marcrubio.practicaslayoutpropina.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}

//        setContentView(R.layout.activity_main)

//        val preu: EditText = findViewById(R.id.cost_of_service)
//        val butonCalculate: Button = findViewById(R.id.calculate_button)
//        val radio20: RadioButton = findViewById(R.id.option_twenty_percent)
//        val radio18: RadioButton = findViewById(R.id.option_eighteen_percent)
//        val radio15: RadioButton = findViewById(R.id.option_fifteen_percent)
//        val switchRound: Switch = findViewById(R.id.round_up_switch)
//        val resualr: TextView = findViewById(R.id.tip_result)
//
//        butonCalculate.setOnClickListener {
//            val preuText = preu.text.toString()
//
//            if (preuText.isNotEmpty()) {
//                val preuValue = preuText.toFloat()
//                var tipPercentage = 0.0
//
//                when {
//                    radio20.isChecked -> tipPercentage = 0.20
//                    radio18.isChecked -> tipPercentage = 0.18
//                    radio15.isChecked -> tipPercentage = 0.15
//                }
//
//                val tipAmount = preuValue * tipPercentage
//
//                if (switchRound.isChecked) {
//                    val roundedTipAmount = Math.round(tipAmount)
//                    resualr.text = "Propina: $roundedTipAmount"
//                } else {
//                    resualr.text = "Propina: $tipAmount"
//                }
//
//            } else {
//                Toast.makeText(this, "Ingresa un valor ", Toast.LENGTH_SHORT).show()
//            }
//        }