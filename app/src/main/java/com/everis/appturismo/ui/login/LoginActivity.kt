package com.everis.appturismo.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.everis.appturismo.R
import com.everis.appturismo.ui.comments.CommentActivity
import com.everis.appturismo.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel =ViewModelProviders.of(this).get(LoginViewModel::class.java)


        btnSignIn.setOnClickListener {
            viewModel.login(edtEmail.text.toString(), edtPass.text.toString())

        }


        textRegister.setOnClickListener {
            goHome()
        }

        observerViewModel()

    }

    fun observerViewModel(){
        viewModel.userLoadError.observe(this, Observer {
            if(it){
                Toast.makeText(this,"Verifique sus credenciales", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.userServiceResponse.observe(this, Observer {
            if (it){
                Toast.makeText(this,"Ingresaste con éxito",Toast.LENGTH_SHORT).show()
                goComments()
            } else{
                Toast.makeText(this,"Verifique sus credenciales",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun goHome(){
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }

    private fun goComments(){
        startActivity(Intent(this, CommentActivity::class.java))
        finish()
    }






}