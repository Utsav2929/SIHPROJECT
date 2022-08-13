package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;

public class relaxingActivityPrimary extends AppCompatActivity {


    DatabaseReference databaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxing_primary);
        ImageButton btn1 = findViewById(R.id.btn1);
        ImageButton btn2 = findViewById(R.id.btn2);
        ImageButton btn3 = findViewById(R.id.btn3);
        ImageButton btn4 = findViewById(R.id.btn4);
        ImageButton btn5 = findViewById(R.id.btn5);
        ImageButton btn6 = findViewById(R.id.btn6);


        String email = getIntent().getExtras().getString("email");

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openWeb("https://bubblespop.netlify.app/",email);
                increasecounter(email);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://www.digipuzzle.net/main/kids/",email);
                increasecounter(email);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://www.teachingexpertise.com/classroom-ideas/school-scavenger-hunts-for-students/",email);

                increasecounter(email);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotojournalism(email);
                increasecounter(email);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHobbies(email);
                increasecounter(email);
            }
        });

    }


    private void increasecounter(String email) {
        LocalDate today=LocalDate.now();

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(email).child("TODO").child(today.toString());
        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
                String progress;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progress = dataSnapshot.child("relaxinactivities").child("progress").getValue().toString();

                if(Integer.parseInt(progress)<=90) {
                    int prg = Integer.parseInt(progress) + 10;

                    reference1.child("relaxinactivities").child("progress").setValue(Integer.toString(prg));

                }else{

                    int prg = 100;

                    reference1.child("relaxinactivities").child("progress").setValue(Integer.toString(prg));

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    private void gotoHobbies(String email) {
        Intent intent = new Intent(relaxingActivityPrimary.this, relaxingHobies.class);

        intent.putExtra("email", email);
        startActivity(intent);
    }
    private void gotojournalism(String email) {
        Intent intent = new Intent(relaxingActivityPrimary.this, relaxingJournaling.class);

        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void openWeb(String url,String email)
    {
        Intent intent = new Intent(relaxingActivityPrimary.this, webView.class);

        intent.putExtra("email", email);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}//ex, hunt riddles, interest, journal, qzs