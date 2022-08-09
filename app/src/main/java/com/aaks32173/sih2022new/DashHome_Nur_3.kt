package com.aaks32173.sih2022new

import android.content.Intent
import com.aaks32173.sih2022new.ui.MainActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class DashHome_Nur_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_home_nur3)

        val poemsandrhymes = findViewById<ImageButton>(R.id.poemsryhmes)

        poemsandrhymes.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","rhymes")
            startActivity(a)
        }

        val stories = findViewById<ImageButton>(R.id.stories)

        stories.setOnClickListener {

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

        val sports = findViewById<ImageButton>(R.id.sports)

        sports.setOnClickListener {

        }
        val gksection = findViewById<ImageButton>(R.id.gksection)

        gksection.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","gksection")
            startActivity(a)
        }
        val wetime = findViewById<ImageButton>(R.id.wetime)

        wetime.setOnClickListener {
            val a = Intent(this, yoga::class.java)
                .putExtra("category","wetime")
            startActivity(a)
        }
        val screentimerecord = findViewById<ImageButton>(R.id.screentimerecord)

        screentimerecord.setOnClickListener {

        }

        val letshaveconversation = findViewById<ImageButton>(R.id.letshaveconversation)

        letshaveconversation.setOnClickListener {

            val a =  Intent(this,com.aaks32173.sih2022new.ui.MainActivity::class.java)
            startActivity(a)


        }

        val todolist = findViewById<ImageButton>(R.id.todolist)

        todolist.setOnClickListener {



        }

        val nowcast = findViewById<ImageButton>(R.id.nowcast)

        nowcast.setOnClickListener {
            val a = Intent(this, Showpost::class.java)
            startActivity(a)
        }

        val relaxingactivity =findViewById<ImageButton>(R.id.relaxingactivity)

        relaxingactivity.setOnClickListener{

            val a = Intent(this, relaxingactivity::class.java)
            startActivity(a)
        }
    }
}