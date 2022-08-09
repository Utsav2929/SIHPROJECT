package com.aaks32173.sih2022new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class DashHome_Nur_3 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_home_nur3)

        val poemsandrhymes = findViewById<ImageButton>(R.id.poemsryhmes)
        val email = FirebaseAuth.getInstance().currentUser?.email

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
            val a = Intent(this, good_bad_touch_panel::class.java)
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


        val letshaveconversation = findViewById<ImageButton>(R.id.letshaveconversation)

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

}