package com.everis.appturismo.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.appturismo.utils.isValidEmail
import com.everis.appturismo.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel :ViewModel() {

    lateinit var auth: FirebaseAuth

    val userRegisterServiceResponse = MutableLiveData<Boolean>()
    val userLoadError = MutableLiveData<Boolean>() //notificar una accion o error

    fun register(email:String, pass:String, rePass:String){
        if (email.isValidEmail() && pass.isValidPassword() && rePass.isValidPassword()) {
            registerFirebase(email, pass,rePass)

        } else {
            userLoadError.value = true
        }
    }

    fun registerFirebase(email: String,pass: String,rePass: String){
        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Log.v("EVR_APP", "isSuccessful")
                    userRegisterServiceResponse.value = true
                } else {
                    Log.v("EVR_APP", "error")
                    userRegisterServiceResponse.value = false
                }
            }
    }

}