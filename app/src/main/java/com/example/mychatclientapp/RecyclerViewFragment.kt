package com.example.mychatclientapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecyclerViewFragment : Fragment() {

    //private lateinit var chatData: MutableList<String>
    private var chatData: ArrayList<String> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var theAdapter: ChatAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initChatData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.recycler_view_fragment,
            container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(activity)
        theAdapter = ChatAdapter(chatData)
        recyclerView.adapter = theAdapter
        recyclerView.layoutManager = layoutManager

        initChatData()
        return rootView
    }


    private fun initChatData() {
        //chatData = ArrayList(50) {i-> (i + 1).toString()}
        chatData.add("First")
        chatData.add("Second")
        Log.d("onCreate" , "chat initiated")
    }

    fun addMessage(text : String){
        Log.d("addMessage", "---before---")
        //chatData.removeAt(0)
        chatData.add(text)
        Log.d("chatData", chatData.size.toString())
        for (i in chatData) {
            Log.d("MessageLog", i)
        }


        Log.d("addMessage", "---after---")
    }

}