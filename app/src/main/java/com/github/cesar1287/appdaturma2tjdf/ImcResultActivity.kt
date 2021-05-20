package com.github.cesar1287.appdaturma2tjdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.appdaturma2tjdf.databinding.ActivityImcResultBinding

class ImcResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc = intent.getDoubleExtra("imc", 0.0)
        val imcResult = when {
            imc < 18.5 -> {
                "MAGREZA"
            }
            imc < 25.0 -> {
                "NORMAL"
            }
            imc < 30.0 -> {
                "SOBREPESO"
            }
            imc < 40.0 -> {
                "OBESIDADE"
            }
            else -> {
                "OBESIDADE GRAVE"
            }
        }

        binding.tvImcResultImcValue.text = "Seu IMC é $imc"
        binding.tvImcResultImcResult.text = "O resultado do IMC é: $imcResult"
    }
}