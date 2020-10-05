package com.everis.appturismo.ui.comments

import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RatingBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.everis.appturismo.R
import com.everis.appturismo.data.Comments
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.add_comentario.*
import kotlinx.android.synthetic.main.add_comentario.view.*
import kotlinx.android.synthetic.main.avtivity_comentarios.*
import kotlinx.android.synthetic.main.items_comentarios.view.*
import java.lang.ref.SoftReference


class CommentActivity: AppCompatActivity() {

    private lateinit var viewModel: CommentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avtivity_comentarios)

        viewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)

        floatingAdd.setOnClickListener { getData() }

        observableViewModel()


    }

    fun observableViewModel(){
        viewModel.commentsListSucces.observe(this, Observer {
            recyclerComments.apply {
                layoutManager = LinearLayoutManager(this@CommentActivity)
                adapter = CommentAdapter(it)
            }
        })
        viewModel.loadData()
    }


    fun getData(){
        val viewDialog = LayoutInflater.from(this).inflate(R.layout.add_comentario, null)
        val dialogBuild = AlertDialog.Builder(this)

        dialogBuild.setView(viewDialog)
            .setView(viewDialog)
            .setTitle("Comentario")

        val dialogAlert = dialogBuild.show()

        viewDialog.btnAdd.setOnClickListener {
            dialogAlert.dismiss()
            val title = viewDialog.edtTitle.text.toString()
            val name = viewDialog.edtName.text.toString()
            val lastName = viewDialog.edtLastName.text.toString()
            val comentario = viewDialog.edtComment.text.toString()
            val calificacion = viewDialog.edtCalificacion.text.toString()

            viewModel.registerData(title, name, lastName, comentario, calificacion)
            viewModel.loadData()

        }
    }
}