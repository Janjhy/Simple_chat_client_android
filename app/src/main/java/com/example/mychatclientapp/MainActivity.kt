package com.example.mychatclientapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.PrintStream
import java.io.PrintWriter
import java.net.InetAddress
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private lateinit var out: PrintStream
    //private lateinit var out1: PrintWriter
    private lateinit var socket: Socket
    private var chatData: ArrayList<String> = arrayListOf()
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var theAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        theAdapter = ChatAdapter(chatData)
        Thread(ChatThread()).start()


        myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = theAdapter
        }

        /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                replace(R.id.chat_text_fragment, RecyclerViewFragment())
                commit()
            }
        }*/
    }

    //Function executes when the send button is pressed.
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        chatData.add(message)

        /*var outThread = Thread(Runnable() {
             fun run() {
                try {
                    Log.d("outThread", "run")
                    out.println(message)
                } catch (e: Exception) {
                    println("Exception: ${e.message}")
                }
            }
        })*/
        var outMessage = Thread(OutThread(message))
        outMessage.start()
        theAdapter.notifyDataSetChanged()
        // RecyclerViewFragment().addMessage(message)

    }

    inner class OutThread(message: String): Runnable {
        private var message = message

        override fun run() {
            try {
                Log.d("outThread", "run")
                out.println(this.message)
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            }
        }
    }

    inner class ChatThread() : Runnable {

        override fun run(){
            try {
                var address: InetAddress = InetAddress.getByName("10.0.2.2")
                socket = Socket(address, 30043)
                //out1 = PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())), true)
                out = PrintStream(socket.getOutputStream(), true)
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            }
        }

    }

    /*
    private fun initChatData() {
        //chatData = ArrayList(50) {i-> (i + 1).toString()}
        chatData.add("First")
        chatData.add("Second")
        Log.d("initChat" , "chat initiated")
    }
    */
}
