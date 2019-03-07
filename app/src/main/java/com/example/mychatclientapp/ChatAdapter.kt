package com.example.mychatclientapp

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.widget.TextView

class ChatAdapter(private val dataSet: Array<String>) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


}