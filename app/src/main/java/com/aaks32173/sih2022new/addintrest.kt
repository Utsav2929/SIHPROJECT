package com.aaks32173.sih2022new

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*

class addintrest : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private var firebaseUserID: String = ""
    private lateinit var subButton : Button
    private  lateinit var age :String
    //    lateinit var title : EditText
//    private lateinit var desc : EditText

    private lateinit var exer : EditText

    private lateinit var wet: EditText

    private lateinit var relact : EditText

    private lateinit var nut : EditText

    private lateinit var mus : EditText
    private lateinit var encodedemmail : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addintrest)

        auth = FirebaseAuth.getInstance()
        val email = FirebaseAuth.getInstance().currentUser?.email

        age = intent.getStringExtra("age").toString()
        encodedemmail=encodeUserEmail(email.toString())
        subButton = findViewById(R.id.submitbutton)

        exer= findViewById(R.id.exercise)
        wet= findViewById(R.id.wetime)
        relact= findViewById(R.id.relaxingactivity)
        nut= findViewById(R.id.nutrition)
        mus= findViewById(R.id.musicpodcast)


        subButton.setOnClickListener {
            registerUser(encodedemmail.toString())
        }
    }

    private fun registerUser(email: String) {


        val exerc: String=exer.text.toString()

        val wett: String=wet.text.toString()

        val rel: String=relact.text.toString()

        val nutt: String=nut.text.toString()

        val music: String=mus.text.toString()

        if (exerc.isBlank()  || wett.isBlank()||rel.isBlank() || nutt.isBlank()|| music.isBlank()) {
            Toast.makeText(this, "All fields are compulsory.", Toast.LENGTH_LONG).show()
            return
        }

        database = FirebaseDatabase.getInstance().getReference("UserInfo/"+email)
        val intrest = intrestclass(exerc,music,rel,nutt,wett)


        Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()


        if (age.toInt() > 8 && age.toInt() <= 11) {
            val intent = Intent(this, fouthFifthGroup::class.java)
            startActivity(intent)
        } else if (age.toInt() <= 14 && age.toInt() > 11) {
            val intent = Intent(this, SixthEighthGroup::class.java)
            startActivity(intent)
        }
    }
}
private fun encodeUserEmail(email: String): String {
    return email.replace(".", ",")
}