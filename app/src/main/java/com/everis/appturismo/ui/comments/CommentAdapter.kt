package com.everis.appturismo.ui.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.everis.appturismo.data.Comments

class CommentAdapter (private val list: List<Comments>):
    RecyclerView.Adapter<CommentViewHolder>(){

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return CommentViewHolder(inflater,parent)

    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        val comments:Comments = list[position]
        holder.bind(comments,holder)
    }



}