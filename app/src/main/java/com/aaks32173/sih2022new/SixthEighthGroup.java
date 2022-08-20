package com.aaks32173.sih2022new;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
public class SixthEighthGroup extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser Currentuser;
    DatabaseReference databaseReference2;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_eighth_group);
        ImageButton menstural = findViewById(R.id.menstural);
        ImageButton relaxing = findViewById(R.id.relaxing);
        ImageButton flextime = findViewById(R.id.flextime);
        ImageButton gtbt = findViewById(R.id.gtbt);
        ImageButton podcast = findViewById(R.id.podcasts);
        ImageButton wetime = findViewById(R.id.wetime);
        ImageButton music = findViewById(R.id.music);
        ImageButton todo = findViewById(R.id.todo);

        ImageButton convo = findViewById(R.id.convo6to8);
        ImageButton diet = findViewById(R.id.diet);
        ImageButton nowcast = findViewById(R.id.nowcast6to8);

        mAuth = FirebaseAuth.getInstance();
        Currentuser = mAuth.getCurrentUser();
        LocalDate td=LocalDate.now();
        DatabaseReference reference12 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(encodeUserEmail(Currentuser.getEmail())).child("WeTime");
        reference12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean todotoday = dataSnapshot.child(td.toString()).exists();
                if(!todotoday){
                    String[][] wetime={
                            {"1","Go for a walk with your parents"},
                            {"2","Have dinner with family"},
                            {"3","Ask your family members to tell you a story before bed."},
                            {"4","Plant a seed with the help with your elder and water it daily"},
                            {"5","Ask your mom to let you help in kitchen. Do as she instructs."},
                            {"6","Tell your mom how good she looks."},
                            {"7","Take blessings from your elders."},
                            {"8","Ask your parents to help you with your TODO list "},
                            {"9","Thank god for givng you such a wonderful family."},
                            {"10","Have a small dance party with songs played on your phone with your family."},
                            {"11","Maintain a piggy bank.Save money and add to it."},
                            {"12","Dress up and join your elders to temples, mosques,churches or gurudwaras"},
                            {"13","Set tables  for meals."},
                            {"14","Go to fruit or vegetable market with your elders."},
                            {"15","Arrange your closet with your elders."},
                            {"16","Check your photo albums with your family."}
                    };
                    databaseReference2 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(encodeUserEmail(Currentuser.getEmail())).child("WeTime");
                    for (int i = 1; i <= 16; i++) {
                        databaseReference2.child(td.toString()).child(""+i).child("status").setValue("False");
                        databaseReference2.child(td.toString()).child(""+i).child("description").setValue(wetime[i-1][1]);
                        databaseReference2.child(td.toString()).child(""+i).child("date").setValue(td.toString());
                        databaseReference2.child(td.toString()).child(""+i).child("id").setValue(wetime[i-1][0]);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(encodeUserEmail(Currentuser.getEmail())).child("info");
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMusic(Currentuser.getEmail().toString());
            }
        });
        wetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoWetime(encodeUserEmail(Currentuser.getEmail().toString()));
            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTodo(encodeUserEmail(Currentuser.getEmail().toString()));
            }
        });


        nowcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixthEighthGroup.this,Showpost.class);
                startActivity(intent);
            }
        });

        convo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTotherapist();
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotodiet();
            }
        });
        podcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPodcats(Currentuser.getEmail().toString());
            }
        });
        flextime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFlex();
            }
        });
        relaxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRelaxing();
            }
        });
        menstural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMenstural();
            }
        });
        gtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetogtbt();
            }
        });}

    private void gotoTotherapist() {
        Intent intent = new Intent(SixthEighthGroup.this, councellor.class);
        startActivity(intent);
    }


    private void gotodiet() {
        Intent intent = new Intent(SixthEighthGroup.this, chekk.class);
        startActivity(intent);
    }

    private void gotoWetime(String email) {
        Intent intent = new Intent(SixthEighthGroup.this, WetimeActivity.class);
        intent.putExtra("email",email);
        startActivity(intent);
    }
    private void gotoPodcats(String email) {
        Intent intent =  new Intent(SixthEighthGroup.this, MusicPlayer.class);
        intent.putExtra("path","PodcastSixthEight");
        intent.putExtra("email", email);
        intent.putExtra("grp", "podcast");
        startActivity(intent);
    }
    private void gotoMusic(String email) {
        Intent intent = new Intent(SixthEighthGroup.this, MusicPlayer.class);
        intent.putExtra("path","MusicFourthFifth");
        intent.putExtra("email", email);
        intent.putExtra("grp", "music");
        startActivity(intent);
    }
    private void movetogtbt() {
        Intent intent =  new Intent(SixthEighthGroup.this, gtbtPanelFourthFifth.class);
        startActivity(intent);
    }
    private void gotoFlex() {
        Intent intent = new Intent(SixthEighthGroup.this, flex_time.class);
        startActivity(intent);
    }
    private void gotoRelaxing() {
        Intent intent = new Intent(SixthEighthGroup.this, relaxingActivityHigher.class);
        startActivity(intent);
    }
    private void gotoMenstural() {
        Intent intent = new Intent(SixthEighthGroup.this, MainActivity.class);
        startActivity(intent);
    }
    private void gotoTodo(String email) {
        Intent intent = new Intent(SixthEighthGroup.this, todo.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    private String encodeUserEmail(String email) {
        return email.replace(".",",");
    }
}