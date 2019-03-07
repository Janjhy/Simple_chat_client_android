package com.example.mychatclientapp

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ChatAdapter(private val chatData: ArrayList<String>) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.textView)
    }

    //Creates views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.MyViewHolder {
        Log.d("chatAdapter", "onCreate")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_text_view, parent, false)
        return MyViewHolder(v)
    }

    //Replace contents of view
    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        Log.d("chatAdapter", "onBind")
        viewHolder.textView.text = chatData[position]
    }

    //Returns size of chatData
    override fun getItemCount(): Int {
        return chatData.size
    }
}