package com.github.cesar1287.appdaturma2tjdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloWorld = findViewById<TextView>(R.id.tvMainHelloWorld)
        helloWorld.text = getString(R.string.hello_world)

        findViewById<Button>(R.id.btMainTapMe).setOnClickListener {
            helloWorld.text = "O número sorteado é ${(Math.random()*100).toInt()}"
        }
    }
}