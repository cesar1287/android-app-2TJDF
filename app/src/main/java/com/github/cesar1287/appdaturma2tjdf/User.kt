package com.github.cesar1287.appdaturma2tjdf

import java.io.Serializable

data class User(
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val number: Double
) : Serializable
