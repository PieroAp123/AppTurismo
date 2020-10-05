package com.everis.appturismo.ui.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.everis.appturismo.R
import com.everis.appturismo.data.Comments

class CommentViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.items_comentarios, parent, false)){

    private var textTitulo: TextView? = null
    private var textName: TextView? = null
    private var textLastName: TextView? = null
    private var addComentario: TextView? = null
    private var addCalificacion: TextView? = null


    init {

        textTitulo = itemView.findViewById(R.id.textTitulo)
        textName = itemView.findViewById(R.id.textName)
        textLastName = itemView.findViewById(R.id.textLastName)
        addComentario = itemView.findViewById(R.id.addComentario)
        addCalificacion = itemView.findViewById(R.id.addCalificacion)

    }

    fun bind(comments: Comments, holder: CommentViewHolder){

        textTitulo?.text = comments.title
        textName?.text = comments.name
        textLastName?.text = comments.lastName
        addComentario?.text = comments.comment
        addCalificacion?.text = comments.qualification
    }

}