package com.example.mychatclientapp

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ChatAdapter(private val dataSet: Array<String>) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}