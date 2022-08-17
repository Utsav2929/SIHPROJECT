package com.aaks32173.sih2022new

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaks32173.sih2022new.databinding.ActivityTodoBinding

import com.google.firebase.database.*
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class todo  : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<usertodo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<usertodo>()

        getUserData()



    }

    private fun getUserData() {

       val email = intent.getStringExtra("email").toString()
        Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()

        val today= LocalDate.now()
        dbref = FirebaseDatabase.getInstance().getReference("UserInfo/"+email+"/TODO/"+today)

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

               if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(usertodo::class.java)
                        userArrayList.add(user!!)


                    }


                    userRecyclerview.adapter = todoadapter(userArrayList)



                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}