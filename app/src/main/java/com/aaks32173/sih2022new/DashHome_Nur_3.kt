package com.aaks32173.sih2022new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.time.LocalDate

class DashHome_Nur_3 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    var databaseReference2: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_home_nur3)

        val poemsandrhymes = findViewById<ImageButton>(R.id.poemsryhmes)
        val email = FirebaseAuth.getInstance().currentUser?.email

         val encodedemmail=encodeUserEmail(email.toString())

        val td = LocalDate.now()

        val reference12 = FirebaseDatabase.getInstance().reference.child("UserInfo").child(encodedemmail.toString()).child("WeTime")

        reference12.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val todotoday = dataSnapshot.child(td.toString()).exists()
                if (!todotoday) {
                    val wetime = arrayOf(
                        arrayOf("1", "Go for a walk with your parents"),
                        arrayOf("2", "Have dinner with family"),
                        arrayOf("3", "Ask your family members to tell you a story before bed."),
                        arrayOf(
                            "4",
                            "Plant a seed with the help with your elder and water it daily"
                        ),
                        arrayOf(
                            "5",
                            "Ask your mom to let you help in kitchen. Do as she instructs."
                        ),
                        arrayOf("6", "Tell your mom how good she looks."),
                        arrayOf("7", "Take blessings from your elders."),
                        arrayOf("8", "Ask your parents to help you with your TODO list "),
                        arrayOf("9", "Thank god for givng you such a wonderful family."),
                        arrayOf(
                            "10",
                            "Have a small dance party with songs played on your phone with your family."
                        ),
                        arrayOf("11", "Maintain a piggy bank.Save money and add to it."),
                        arrayOf(
                            "12",
                            "Dress up and join your elders to temples, mosques,churches or gurudwaras"
                        ),
                        arrayOf("13", "Set tables  for meals."),
                        arrayOf("14", "Go to fruit or vegetable market with your elders."),
                        arrayOf("15", "Arrange your closet with your elders."),
                        arrayOf("16", "Check your photo albums with your family.")
                    )
                     databaseReference2 = FirebaseDatabase.getInstance().reference.child("UserInfo").child(encodedemmail!!).child("WeTime")
                    for (i in 1..16) {
                        databaseReference2!!.child(td.toString()).child("" + i).child("status")
                            .setValue("False")
                        databaseReference2!!.child(td.toString()).child("" + i).child("description")
                            .setValue(
                                wetime[i - 1][1]
                            )
                        databaseReference2!!.child(td.toString()).child("" + i).child("date")
                            .setValue(td.toString())
                        databaseReference2!!.child(td.toString()).child("" + i).child("id")
                            .setValue(wetime[i - 1][0])
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

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
                .putExtra("email",encodedemmail)
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