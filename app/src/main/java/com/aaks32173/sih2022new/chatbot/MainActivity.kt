package com.aaks32173.sih2022new.chatbot

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaks32173.sih2022new.R
import com.aaks32173.sih2022new.depressn_main
import com.aaks32173.sih2022new.good_bad_touch_panel
import com.aaks32173.sih2022new.phq_9
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chatbotsenior.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var  auth:FirebaseAuth
    private lateinit var database:DatabaseReference
    var tempmsg=""
        var count=0
    private val adapterChatBot = AdapterChatBot()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbotsenior)
   val question = arrayOf("go walk with your parents","have dinner with your family", "tell your parents to tell you story in bed","tell your parents to play with you" )

        for (i in 1..4){





        }







        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.2.107:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)

        rvChatList.layoutManager = LinearLayoutManager(this)
        rvChatList.adapter = adapterChatBot

        adapterChatBot.addChatToList(ChatModel("Hello User"!!, true))
        btnSend.setOnClickListener {
            if(etChat.text.isNullOrEmpty()){
                Toast.makeText(this@MainActivity, "Please enter a text", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            adapterChatBot.addChatToList(ChatModel(etChat.text.toString()))
            tempmsg=etChat.text.toString()

            apiService.chatWithTheBit(etChat.text.toString()).enqueue(callBack)
            etChat.text.clear()
        }
    }

    private val callBack = object  : Callback<ChatResponse>{
        override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
            if(response.isSuccessful &&  response.body()!= null){
                adapterChatBot.addChatToList(ChatModel(response.body()!!.chatBotReply, true))
                val i = response.body()!!.sentiment

                if (i == "0") {
                    increasecounter(tempmsg)

                }
                    else if(i=="1") {
                        count=count+1
                        Toast.makeText(this@MainActivity, count.toString(), Toast.LENGTH_LONG)
                            .show()

                    }


                if(count==2){
                    Toast.makeText(this@MainActivity, count.toString(), Toast.LENGTH_LONG).show()
                  gotodepressionmain()

                }
                if(response.body()!!.chatBotReply=="you can try relaxing activities "){
                    Toast.makeText(this@MainActivity, "intent to sleep schedule", Toast.LENGTH_LONG).show()
                    gotorelaxingactivityhigher()

                }
            }
            else{


                adapterChatBot.addChatToList(ChatModel("try again"!!, true))


            }



        }

        override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Something went wrong2", Toast.LENGTH_LONG).show()
        }

    }
    fun gotodepressionmain() {
        val a = Intent(this, phq_9::class.java)
        startActivity(a)
    }

    fun gotorelaxingactivityhigher() {
        val a = Intent(this, com.aaks32173.sih2022new.relaxingActivityHigher::class.java)
        startActivity(a)
    }


    private fun increasecounter(desc:String) {


        val email = FirebaseAuth.getInstance().currentUser?.email
        val reference1 = FirebaseDatabase.getInstance().reference.child("UserInfo/"+email.toString())
//                .child(encodeUserEmail(email.toString()).toString())
        reference1.addListenerForSingleValueEvent(object : ValueEventListener {
            var progress: String? = null
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                progress =
                    dataSnapshot.child("chat").value.toString()

                reference1.child("chat").setValue(progress+desc)

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }




}