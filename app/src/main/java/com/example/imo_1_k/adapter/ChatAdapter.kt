package com.example.imo_1_k.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imo_1_k.R
import com.example.imo_1_k.model.Chat
import com.google.android.material.imageview.ShapeableImageView



class ChatAdapter(var contex: Context, var items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view, parent, false)

        return MessageViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if(holder is MessageViewHolder){
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var tv_count = holder.tv_count

            Glide.with(contex).load(chat.profile).into(iv_profile)
            tv_fullname.text = chat.fullname
            tv_count.text= chat.count.toString()

            if (chat.count > 0){
                tv_count.visibility = View.VISIBLE
            }else{
                tv_count.visibility = View.GONE
            }
        }
    }

    class MessageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile: ImageView
        var tv_fullname: TextView
        var tv_count: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            tv_count = view.findViewById(R.id.tv_count)
        }
    }
}