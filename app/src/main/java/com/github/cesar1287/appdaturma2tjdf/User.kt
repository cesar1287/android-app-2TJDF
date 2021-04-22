package com.github.cesar1287.appdaturma2tjdf

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val number: Double
) : Parcelable
