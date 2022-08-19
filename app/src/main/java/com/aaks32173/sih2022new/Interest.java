package com.aaks32173.sih2022new;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Interest extends AppCompatActivity implements QuantityListener {

    RecyclerView recyler_view ;
    QuantityAdapter adapter;
    ArrayList<String> arrayList = new ArrayList<>() ;
    FirebaseAuth mAuth;
    String age;
    FirebaseUser Currentuser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Currentuser = mAuth.getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(encodeUserEmail(Currentuser.getEmail())).child("UserIntrest");
        age= getIntent().getExtras().getString("age");


        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        ImageView img4 = findViewById(R.id.img4);
        ImageView img5 = findViewById(R.id.img5);
        ImageView img6 = findViewById(R.id.img6);
        ImageView img7 = findViewById(R.id.img7);
        ImageView img8 = findViewById(R.id.img8);
        ImageView img9 = findViewById(R.id.img9);
        Button next = findViewById(R.id.next_Button);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("exercise", img1);

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("dancing", img2);

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("indoorgames", img3);

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("music", img4);

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("drawing", img5);

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("travel", img6);

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("reading", img7);

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("sports", img8);

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtoList("yoga", img9);

            }
        });


//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                snapshot.child("exercise")
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        })
        //setRecyclerView() ;
        Button button=(Button)findViewById(R.id.next_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                movetohome();
            }
        });
    }

    private void getData() {
        if(arrayList.contains("exercise"))
        {
            ref.child("exercise").setValue("5");
        }
        else
        ref.child("exercise").setValue("0");
        if(arrayList.contains("dancing"))
        {
            ref.child("dancing").setValue("5");
        }
        else{
            ref.child("dancing").setValue("0");
        }
        if(arrayList.contains("indoorgames"))
        {
            ref.child("indoorgames").setValue("5");
        }
        else{
            ref.child("indoorgames").setValue("0");
        }
        if(arrayList.contains("music"))
        {
            ref.child("music").setValue("5");
        }
        else{
            ref.child("music").setValue("0");
        }
        if(arrayList.contains("drawing"))
        {
            ref.child("drawing").setValue("5");
        }
        else{
            ref.child("drawing").setValue("0");
        }
        if(arrayList.contains("travel"))
        {
            ref.child("travel").setValue("5");
        }
        else{
            ref.child("travel").setValue("0");
        }
        if(arrayList.contains("reading"))
        {
            ref.child("reading").setValue("5");
        }
        else{
            ref.child("reading").setValue("0");
        }
        if(arrayList.contains("sports"))
        {
            ref.child("sports").setValue("5");
        }
        else{
            ref.child("sports").setValue("0");
        }
        if(arrayList.contains("yoga"))
        {
            ref.child("yoga").setValue("5");
        }
        else{
            ref.child("yoga").setValue("0");
        }
    }

    private void addtoList(String s, ImageView v) {
        if(arrayList.contains(s))
        {
            arrayList.remove(s);
            v.setBackgroundResource(R.color.white);
        }
        else{
            arrayList.add(s);
            v.setBackgroundResource(R.color.blue);
          //  Toast.makeText(this, arrayList.toString(),Toast.LENGTH_SHORT ).show();
        }
    }

    private void movetohome() {

        Intent intent = new Intent(Interest.this, Details.class);
        intent.putExtra("age", age);
        startActivity(intent);
    }


//    private ArrayList<String> getQuantityData(){
//        ArrayList<String> arrayList = new ArrayList<>() ;
//        arrayList.add("Workout and Exercise");
//        arrayList.add("Dance");
//        arrayList.add("Indoor Games");
//        arrayList.add("Art & Sketching");
//        arrayList.add("Reading Books");
//        arrayList.add("Sports");
//        arrayList.add("Music");
//        arrayList.add("Travelling");
//        arrayList.add("Yoga & Meditation");
//
//        return arrayList ;
//    }
//    private void setRecyclerView() {
//        recyler_view.setHasFixedSize(true);
//        recyler_view.setLayoutManager(new LinearLayoutManager(this));
//        adapter=new QuantityAdapter(this,getQuantityData(),this) ;
//        recyler_view.setAdapter(adapter);
//    }

    @Override
    public void onQuantityChange(ArrayList<String> arrayList) {
        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();
    }
    private String encodeUserEmail(String email) {
        return email.replace(".",",");
    }

}