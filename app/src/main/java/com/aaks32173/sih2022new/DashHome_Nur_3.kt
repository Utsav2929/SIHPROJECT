package com.aaks32173.sih2022new

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class DashHome_Nur_3 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    var recycler_view: RecyclerView? = null
    var autoScrollAdapter: AutoScrollAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_home_nur3)

        val poemsandrhymes = findViewById<ImageButton>(R.id.poemsryhmes)
        val email = FirebaseAuth.getInstance().currentUser?.email
        recycler_view = findViewById(R.id.recycler_view)
        setRV()

         val encodedemmail=encodeUserEmail(email.toString())
        val email1="hi123@gmail,com"
        Toast.makeText(applicationContext, email.toString(), Toast.LENGTH_SHORT).show()

        poemsandrhymes.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","rhymes")
            startActivity(a)
        }

        val stories = findViewById<ImageButton>(R.id.stories)

        stories.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","stories")
            startActivity(a)
        }
        val gtbt = findViewById<ImageButton>(R.id.gtbt)

        gtbt.setOnClickListener {
            val a = Intent(this, goodBadtouch::class.java)
            startActivity(a)
        }

        val fightyourfear = findViewById<ImageButton>(R.id.fightyourfear)

        fightyourfear.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","fightyourfear")
            startActivity(a)
        }


        val gksection = findViewById<ImageButton>(R.id.gksection)

        gksection.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","gksection")
            startActivity(a)
        }
        val wetime = findViewById<ImageButton>(R.id.wetime)

        wetime.setOnClickListener {
            val a = Intent(this, WetimeActivity::class.java)
                .putExtra("email",email1)
                startActivity(a)
        }




        val letshaveconversation = findViewById<ExtendedFloatingActionButton>(R.id.chatbot)

        val badge = findViewById<TextView>(R.id.chatbotbadge)
        val myanim2 = AnimationUtils.loadAnimation(this, R.anim.shake)
        letshaveconversation.startAnimation(myanim2)
        badge.startAnimation(myanim2)
        letshaveconversation.setOnClickListener {

            val a =  Intent(this,com.aaks32173.sih2022new.ui.MainActivity::class.java)

            startActivity(a)


        }

        val health = findViewById<ImageButton>(R.id.health)

        health.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","health")
            startActivity(a)


        }

        val nowcast = findViewById<ImageButton>(R.id.nowcast)

        nowcast.setOnClickListener {
            val a = Intent(this, Showpost::class.java)
            startActivity(a)
        }

        val relaxingactivity =findViewById<ImageButton>(R.id.relaxingactivity)

        relaxingactivity.setOnClickListener{

            val a = Intent(this, relaxingActivityKids::class.java)
            startActivity(a)
        }
    }

    private fun encodeUserEmail(email: String): String? {
        return email.replace(".", ",")
    }
    private fun setRV() {
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view!!.layoutManager = layoutManager
        autoScrollAdapter = AutoScrollAdapter(this)
        recycler_view!!.adapter = autoScrollAdapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler_view)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (layoutManager!!.findLastCompletelyVisibleItemPosition() < autoScrollAdapter!!.itemCount - 1) {
                    layoutManager!!.smoothScrollToPosition(
                        recycler_view,
                        RecyclerView.State(),
                        layoutManager!!.findLastCompletelyVisibleItemPosition() + 1
                    )
                } else if (layoutManager!!.findLastCompletelyVisibleItemPosition() < autoScrollAdapter!!.itemCount - 1) {
                    layoutManager!!.smoothScrollToPosition(recycler_view, RecyclerView.State(), 0)
                }
                run {}
            }
        }, 0, 6000)
    }

}