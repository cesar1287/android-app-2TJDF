package com.github.cesar1287.appdaturma2tjdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.cesar1287.appdaturma2tjdf.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("lifecycle", "onCreate - Login")

        with(binding) {
            btLoginContinue.setOnClickListener {
                val name = tieLoginName.text.toString()
                val email = tieLoginEmail.text.toString()
                val password = tieLoginPassword.text.toString()

                if (name.isBlank()) {
                    tilLoginName.error = "Campo de nome vazio e/ou inválido"
                } else {
                    tilLoginName.isErrorEnabled = false
                }

                Toast.makeText(
                    this@LoginActivity,
                    "Usuário salvo com sucesso",
                    Toast.LENGTH_SHORT
                ).show()

                val user = User(
                    number = 100.0,
                    password = password,
                    name = name,
                    age = 26,
                    email = email
                )

                //PARCELABLE
                //SERIALIZABLE

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(KEY_INTENT_USER, user)

                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_INTENT_NAME = "name"
        const val KEY_INTENT_EMAIL = "email"
        const val KEY_INTENT_PASSWORD = "password"
        const val KEY_INTENT_AGE = "age"
        const val KEY_INTENT_NUMBER = "number"
        const val KEY_INTENT_USER = "user"
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "onStart - Login")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "onResume - Login")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "onPause - Login")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop - Login")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("lifecycle", "onDestroy - Login")
    }
}