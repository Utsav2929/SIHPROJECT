package com.aaks32173.sih2022new;

import static ai.api.util.ParametersConverter.parseFloat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;

public class flextimefourthfifth extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mauth;
    FirebaseUser Currentuser;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flextimefourthfifth);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mauth = FirebaseAuth.getInstance();
        //sleepdetail = false;

        email = getIntent().getExtras().getString("email");
//                LottieAnimationView gif2 =findViewById(R.id.gif1_exercise_3to5);
//        gif2.setImageResource(R.drawable.exercisegif_3to5);


        Currentuser = mauth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("FlexFouthFifth");
        LinearLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("1");

                increasecounter(email);
            }
        });
        LinearLayout btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("7");

                increasecounter(email);
            }
        });
        LinearLayout btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("2");

                increasecounter(email);
            }
        });
        LinearLayout btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("3");

                increasecounter(email);
            }
        });
        LinearLayout btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("4");

                increasecounter(email);
            }
        });
        LinearLayout btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("5");

                increasecounter(email);
            }
        });
        LinearLayout btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("6");

                increasecounter(email);
            }
        });

    }

    public void getfun(String s) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String url = dataSnapshot.child("Vedio" + s).getValue().toString();
                Intent intent = new Intent(flextimefourthfifth.this, vedioPlay.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

    }

    private void increasecounter(String email) {
        LocalDate today = LocalDate.now();

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(email).child("TODO").child(today.toString());
        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            String progress;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progress = dataSnapshot.child("exercise").child("progress").getValue().toString();

                if (Integer.parseInt(progress) <= 90) {
                    int prg = Integer.parseInt(progress) + 10;

                    reference1.child("exercise").child("progress").setValue(Integer.toString(prg));

                    if(prg==100) {

                        reward() ;
                    }
                } else if(Integer.parseInt(progress)==100){

                    int prg = 100;

                    reference1.child("exercise").child("progress").setValue(Integer.toString(prg));
                    reward();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    void reward() {
        DatabaseReference reference1 =
                FirebaseDatabase.getInstance().getReference().child("UserInfo").child(email);

        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                DatabaseReference reference2 =
                        FirebaseDatabase.getInstance().getReference().child("UserInfo").child(email);
                String rew = snapshot.child("rewards").getValue().toString();

                int rev = Integer.parseInt(rew) + 50;
                reference2.child("rewards").setValue(rev + "");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}