package com.github.cesar1287.appdaturma2tjdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.cesar1287.appdaturma2tjdf.databinding.ActivityImcInputBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.pow

class ImcInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcInputBinding

    private var heightValid = false
    private var weightValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tieImcInputHeight.setOnFocusChangeListener { _, focus ->
                if (!focus) {
                    val height = tieImcInputHeight.text.toString()
                    when {
                        height.isBlank() -> {
                            tilImcInputHeight.error = "Campo obrigatório"
                            heightValid = false
                        }
                        height.toInt() > 300 -> {
                            tilImcInputHeight.error = "Altura inválida"
                            heightValid = false
                        }
                        else -> {
                            tilImcInputHeight.isErrorEnabled = false
                            heightValid = true
                        }
                    }
                }
            }

            tieImcInputWeight.setOnFocusChangeListener { _, focus ->
                if (!focus) {
                    val weight = tieImcInputWeight.text.toString()
                    when {
                        weight.isBlank() -> {
                            tilImcInputWeight.error = "Campo obrigatório"
                            weightValid = false
                        }
                        weight.toInt() > 200 -> {
                            tilImcInputWeight.error = "Peso inválido"
                            weightValid = false
                        }
                        else -> {
                            tilImcInputWeight.isErrorEnabled = false
                            weightValid = true
                        }
                    }
                }
            }

            btImcInputCalculate.setOnClickListener {
                tieImcInputHeight.clearFocus()
                tilImcInputWeight.clearFocus()
                if (heightValid && weightValid) {
                    val height = tieImcInputHeight.text.toString().toDouble() / 100
                    val weight = tieImcInputWeight.text.toString().toInt()
                    // IMC peso / altura²
                    val imc = weight / height.pow(2)
                    val imcResult = String.format("%.1f", imc).toDouble()

                    val intent = Intent(this@ImcInputActivity, ImcResultActivity::class.java)
                    intent.putExtra("imc", imcResult)
                    startActivity(intent)
                } else {
                    Snackbar.make(
                        btImcInputCalculate,
                        "Campos inválidos, favor conferir!",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}