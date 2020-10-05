package com.everis.appturismo.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.everis.appturismo.R
import com.everis.appturismo.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        btnRegister.setOnClickListener {
            viewModel.register(
                edtEmail.text.toString(),
                edtPass.text.toString(),
                edtRepeatPass.text.toString()
            )
        }

        observerViewModel()

    }

    fun observerViewModel(){
        viewModel.userRegisterServiceResponse.observe(this, Observer {
            if (it){
                Toast.makeText(this,"Registrado con éxito",Toast.LENGTH_SHORT).show()
                goLogin()
            } else{
                Toast.makeText(this,"Verifique sus datos ingresados",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun goLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }






}