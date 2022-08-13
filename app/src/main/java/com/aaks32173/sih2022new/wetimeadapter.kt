package com.aaks32173.sih2022new

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.time.LocalDate

class wetimeadapter(private val userList : ArrayList<wetime> ,val email :String) : RecyclerView.Adapter<wetimeadapter.MyViewHolder>() {


    private lateinit var database : DatabaseReference

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

//        userList.sortBy { it.percent?.toInt() }
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_listwetime,
            parent,false)



        return MyViewHolder(itemView)



    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]


        holder.name.text = currentitem.description

        holder.btndelete.setOnClickListener() {
            val today= LocalDate.now()

            database = FirebaseDatabase.getInstance().getReference("UserInfo/"+email+"/WeTime/"+today.toString())

                database.child(currentitem.id.toString()).removeValue().addOnSuccessListener {
                    increasecounter(email)
                }

        }


    }



    override fun getItemCount(): Int {

        return userList.size
    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //        val cname : TextView = itemView.findViewById(R.id.cname)
        val name : TextView = itemView.findViewById(R.id.tvfirstName)



        val btndelete : Button = itemView.findViewById(R.id.btndelete)






    }


    private fun increasecounter(email: String) {
        val today = LocalDate.now()
        val reference1 =
            FirebaseDatabase.getInstance().reference.child("UserInfo").child(email).child("TODO")
                .child(today.toString())
        reference1.addListenerForSingleValueEvent(object : ValueEventListener {
            var progress: String? = null
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                progress =
                    dataSnapshot.child("wetime").child("progress").value.toString()
                if (progress!!.toInt() <= 90) {
                    val prg = progress!!.toInt() + 10
                    reference1.child("wetime").child("progress")
                        .setValue(Integer.toString(prg))
                } else {
                    val prg = 100
                    reference1.child("wetime").child("progress")
                        .setValue(Integer.toString(prg))
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }


}