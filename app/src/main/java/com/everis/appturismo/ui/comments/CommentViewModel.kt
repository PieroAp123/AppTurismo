package com.everis.appturismo.ui.comments

import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.appturismo.R
import com.everis.appturismo.data.Comments
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.add_comentario.view.*

class CommentViewModel: ViewModel(){

    lateinit var firestore: FirebaseFirestore
    val commentsListSucces = MutableLiveData<List<Comments>>()

    fun loadData(){

        var listComments = arrayListOf<Comments>()

        firestore = FirebaseFirestore.getInstance()

        firestore.collection("comments")
            .get()
            .addOnSuccessListener {

                for (document in it){
                    val myObj = document.toObject(Comments::class.java)
                    listComments.add(myObj)
                }

                commentsListSucces.value = listComments
            }
            .addOnFailureListener {

            }

    }

    fun registerData(title:String, name:String, lastName: String, comentario:String, calificacion:String){

        var comments = hashMapOf(
            "title" to title,
            "name" to name,
            "lastName" to lastName,
            "comment" to comentario,
            "qualification" to calificacion
        )

        firestore = FirebaseFirestore.getInstance()

        firestore.collection("comments")
            .add(comments)
            .addOnSuccessListener {
                Log.v("App_Turismo","Se agregó correctamente")
            }
            .addOnFailureListener {
                Log.v("App_Turismo","No se pudo agregar")
            }
    }

}