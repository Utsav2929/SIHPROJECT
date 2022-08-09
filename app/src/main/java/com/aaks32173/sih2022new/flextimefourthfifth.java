package com.aaks32173.sih2022new;

import static ai.api.util.ParametersConverter.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class flextimefourthfifth extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mauth;
    FirebaseUser Currentuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flextimefourthfifth);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mauth = FirebaseAuth.getInstance();
        //sleepdetail = false;
        Currentuser = mauth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("FlexFouthFifth");
        LinearLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("1");
            }
        });
        LinearLayout btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("7");
            }
        });
        LinearLayout btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("2");
            }
        });
        LinearLayout btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("3");
            }
        });
        LinearLayout btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("4");
            }
        });
        LinearLayout btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("5");
            }
        });
        LinearLayout btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfun("6");
            }
        });

}
public  void getfun(String s)
{
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            String url = dataSnapshot.child("Vedio"+s).getValue().toString();
            Intent intent = new Intent(flextimefourthfifth.this, vedioPlay.class);
            intent.putExtra("url", url);
            startActivity(intent);
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {
        }

    });

}
}