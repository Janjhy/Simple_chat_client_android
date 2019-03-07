package com.example.mychatclientapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                replace(R.id.chat_text_fragment, RecyclerViewFragment())
                commit()
            }
        }
    }

    //Function executes when the send button is pressed.
    fun sendMessage(view: View) {

    }


}
