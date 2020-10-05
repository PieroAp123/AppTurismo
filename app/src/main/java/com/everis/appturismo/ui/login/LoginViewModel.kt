package com.everis.appturismo.ui.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.appturismo.utils.isValidEmail
import com.everis.appturismo.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel :ViewModel(){

    lateinit var auth: FirebaseAuth

    val userLoadError = MutableLiveData<Boolean>() //notificar una accion o error
    val userServiceResponse = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun login(email:String, password: String){
        if (email.isValidEmail() && password.isValidPassword()) {
            loginFirebase(email, password)
        } else {
            userLoadError.value = true
        }
    }


    fun loginFirebase(email:String, password: String){

        loading.value = true

        auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(Activity()) {
                if(it.isSuccessful){
                    Log.v("EVR_APP", "isSuccessful")
                    userServiceResponse.value = true
                } else {
                    Log.v("EVR_APP", "error")
                    userServiceResponse.value = false
                }
            }
    }

}