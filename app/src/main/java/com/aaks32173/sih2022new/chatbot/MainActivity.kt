package com.aaks32173.sih2022new.chatbot

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaks32173.sih2022new.R
import com.aaks32173.sih2022new.good_bad_touch_panel
import kotlinx.android.synthetic.main.activity_chatbotsenior.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val adapterChatBot = AdapterChatBot()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbotsenior)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.2.107:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)

        rvChatList.layoutManager = LinearLayoutManager(this)
        rvChatList.adapter = adapterChatBot

        btnSend.setOnClickListener {
            if(etChat.text.isNullOrEmpty()){
                Toast.makeText(this@MainActivity, "Please enter a text", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            adapterChatBot.addChatToList(ChatModel(etChat.text.toString()))
            apiService.chatWithTheBit(etChat.text.toString()).enqueue(callBack)
            etChat.text.clear()
        }
    }

    private val callBack = object  : Callback<ChatResponse>{
        override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
            if(response.isSuccessful &&  response.body()!= null){
                adapterChatBot.addChatToList(ChatModel(response.body()!!.chatBotReply, true))

            }
            if(response.body()!!.chatBotReply=="you can try relaxing activities "){
                Toast.makeText(this@MainActivity, "intent to sleep schedule", Toast.LENGTH_LONG).show()
                gotorelaxingactivityhigher()

            }


        }

        override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Something went wrong2", Toast.LENGTH_LONG).show()
        }

    }

     fun gotorelaxingactivityhigher() {
        val a = Intent(this, com.aaks32173.sih2022new.relaxingActivityHigher::class.java)
        startActivity(a)
    }
}