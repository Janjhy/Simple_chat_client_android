package com.example.mychatclientapp

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class ChatAdapter(private val chatData: Array<String>) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    //Creates views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.my_text_view, parent, false) as TextView
        return MyViewHolder(textView)
    }

    //Replace contents of view
    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.textView.text = chatData[position]
    }

    //Returns size of chatData
    override fun getItemCount(): Int {
        return chatData.size
    }
}