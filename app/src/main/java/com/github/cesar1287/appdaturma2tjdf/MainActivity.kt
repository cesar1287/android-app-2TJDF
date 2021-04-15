package com.github.cesar1287.appdaturma2tjdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_AGE
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_EMAIL
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_NAME
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_NUMBER
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_PASSWORD
import com.github.cesar1287.appdaturma2tjdf.LoginActivity.Companion.KEY_INTENT_USER

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("lifecycle", "onCreate - Main")

//        val name = intent.getStringExtra(KEY_INTENT_NAME)
//        val email = intent.getStringExtra(KEY_INTENT_EMAIL)
//        val password = intent.getStringExtra(KEY_INTENT_PASSWORD)
//        val age = intent.getIntExtra(KEY_INTENT_AGE, 0)
//        val number = intent.getDoubleExtra(KEY_INTENT_NUMBER, 0.0)

        val user = intent.getSerializableExtra(KEY_INTENT_USER) as User

        val helloWorld = findViewById<TextView>(R.id.tvMainHelloWorld)
        helloWorld.text = "Meu nome é ${user.name}\n" +
                "Meu email é ${user.email}\n" +
                "Minha senha é ${user.password}\n" +
                "Minha idade é ${user.age} - ${user.number}"

        findViewById<Button>(R.id.btMainTapMe).setOnClickListener {
            helloWorld.text = "O número sorteado é ${(Math.random()*100).toInt()}"
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("lifecycle", "onStart - Main")
    }

    override fun onResume() {
        super.onResume()

        Log.i("lifecycle", "onResume - Main")
    }

    override fun onPause() {
        super.onPause()

        Log.i("lifecycle", "onPause - Main")
    }

    override fun onStop() {
        super.onStop()

        Log.i("lifecycle", "onStop - Main")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("lifecycle", "onDestroy - Main")
    }
}