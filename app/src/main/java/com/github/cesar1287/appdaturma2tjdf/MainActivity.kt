package com.github.cesar1287.appdaturma2tjdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("lifecycle", "onCreate - Main")

        val helloWorld = findViewById<TextView>(R.id.tvMainHelloWorld)
        helloWorld.text = getString(R.string.hello_world)

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