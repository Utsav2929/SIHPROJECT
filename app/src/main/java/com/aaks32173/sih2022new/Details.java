package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Details extends AppCompatActivity {

    EditText heightt, weightt;
    Button bmi,next;
    String check;
    TextView showbmi, bmiinfo;
    DatabaseReference dbref;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;


    DatabaseReference dbref1;
    private FirebaseAuth mAuth1;
    private FirebaseUser mCurrentUser1;
    RadioGroup radioGroup;
    RadioButton rb1,rb2;
    String diet;
    String final_email ="";
    int age1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        heightt = findViewById(R.id.height);
        weightt = findViewById(R.id.weight);
        bmi = findViewById(R.id.bmibtn);
        showbmi = findViewById(R.id.bmishow);
        bmiinfo = findViewById(R.id.bmiinfo);
        next = findViewById(R.id.next_bmi);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();



        mAuth1 = FirebaseAuth.getInstance();
        mCurrentUser1 = mAuth1.getCurrentUser();

        radioGroup=findViewById(R.id.radioGroup);



        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Float h= Float.parseFloat(String.valueOf(heightt.getText()));
                Float w= Float.parseFloat(String.valueOf(weightt.getText()));
                h=h/100;
                Float b=w/(h*h);
                bmiinfo.setVisibility(view.getVisibility());

                if (b < 18.5) {
                    check = "Under Weight";
                } else if (b >= 18.5 && b < 24.9) {
                    check = "Healthy";
                } else if (b >= 24.9 && b < 30) {
                    check = "Overweight";
                } else if (b >= 30) {
                    check = "Suffering from Obesity";
                }
                bmiinfo.setText(check);
                showbmi.setVisibility(view.getVisibility());
                showbmi.setText(b.toString());
                next.setVisibility(view.getVisibility());
                String email = mAuth.getCurrentUser().getEmail();
                final_email = encodeUserEmail(email);
                dbref = FirebaseDatabase.getInstance().getReference("UserInfo").child(final_email).child("BMI");
                dbref.child("height").setValue(h.toString());
                dbref.child("weight").setValue(w.toString());
                dbref.child("bmi").setValue(b.toString());
                dbref.child("condition").setValue(check);

            }
        });

//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i= new Intent(Details.this,Diett.class);
//                finish();
//                startActivity(i);
//            }
//        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= mCurrentUser1.getEmail();
//                Toast.makeText(view.getContext(), "2", Toast.LENGTH_SHORT).show();
                dbref = FirebaseDatabase.getInstance().getReference("UserInfo").child(final_email);
                dbref.child("userDiet").setValue(diet);

                Intent i = new Intent(Details.this,fouthFifthGroup.class);
                finish();
                startActivity(i);
            }
        });

    }

    private void getUserData() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(final_email).child("info");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String age = dataSnapshot.child("age").getValue().toString();
                dbref = FirebaseDatabase.getInstance().getReference("UserInfo").child(final_email);
                dbref.child("age").setValue(age);

                age1=Integer.parseInt(age);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void rbclick(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        rb1 = findViewById(radioId);
        diet =rb1.getText().toString();
//        Toast.makeText(this, diet,
//                Toast.LENGTH_SHORT).show();
    }

    private String encodeUserEmail(String email) {
        return email.replace(".", ",");
    }

}