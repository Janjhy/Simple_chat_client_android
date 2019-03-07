package com.example.mychatclientapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecyclerViewFragment : Fragment() {

    private lateinit var chatData: Array<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.recycler_view_fragment,
            container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ChatAdapter(chatData)


        return rootView
    }

    private fun initDataset() {
        chatData = Array(50, {i -> "This is element -> $i"})
    }

}