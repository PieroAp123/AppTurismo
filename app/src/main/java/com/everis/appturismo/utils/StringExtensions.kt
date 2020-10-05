package com.everis.appturismo.utils

import android.util.Patterns

fun main(){


}

fun String.isValidEmail() : Boolean{
    return this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean{
    return this.isNotEmpty() && this.length <= 12
}

fun String.containsDigit(): Boolean {
    return this.matches(Regex(".*[0-9]*."))
}

fun String.containsLetter(): Boolean {
    return this.matches(Regex(".*[A-Za-z]*."))
}