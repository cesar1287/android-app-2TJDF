package com.github.cesar1287.appdaturma2tjdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("lifecycle", "onCreate - Main")
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