package com.aaks32173.sih2022new

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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


        holder.name.text = currentitem.Description


        holder.btndelete.setOnClickListener() {
            val today= LocalDate.now()
            currentitem.Status="TRUE"

            database = FirebaseDatabase.getInstance().getReference("UserInfo/"+email+"/WeTime")
            val at= wetime(currentitem.ID, currentitem.Description,currentitem.Status)

                database.child(currentitem.ID.toString()).setValue(at).addOnSuccessListener {

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


}