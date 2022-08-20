package com.aaks32173.sih2022new

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaks32173.sih2022new.databinding.ActivityTodoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import java.lang.Integer.*
import java.time.LocalDate
import java.util.*

class todo  : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<usertodo>
    private lateinit var mauth :FirebaseAuth
    private lateinit var Currentuser : FirebaseUser
    private lateinit var email:String
    private lateinit var imageView: ImageView
    private lateinit var age:Integer

    private lateinit var dbref1 : DatabaseReference

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        imageView = findViewById(R.id.todobgimg)

        userArrayList = arrayListOf<usertodo>()

        mauth = FirebaseAuth.getInstance()
        Currentuser = mauth.getCurrentUser()!!
        email = Currentuser.email.toString()
        dbref1 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(
            encodeUserEmail(email).toString()
        ).child("info");
        dbref1.child("age").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    val age1= (snapshot.getValue().toString()).toInt()
                    if (age1>10){
                        imageView.setBackground(getDrawable(R.drawable.todolistbgcheck))
                    }
                    else
                    {
                        imageView.setBackground(getDrawable(R.drawable.todo_bg))

                    }

                }                }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        getUserData()



    }

    @RequiresApi(Build.VERSION_CODES.O)
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
    private fun encodeUserEmail(email: String): String? {
        return email.replace(".", ",")
    }

}