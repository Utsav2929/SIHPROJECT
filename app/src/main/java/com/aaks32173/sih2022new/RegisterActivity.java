package com.aaks32173.sih2022new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    EditText register_name,register_email,register_password,register_confirm_password,register_age,register_sssm_id,register_family_id;
    Button register_registerbtn;
    RadioButton radioButton;
    FirebaseAuth mAuth;
    RadioGroup radioGroup;
    String gender;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final TextView register_loginnow = findViewById(R.id.register_loginnow);
        register_loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetologin();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        register_name = findViewById(R.id.register_name);
        register_email = findViewById(R.id.register_email);
        register_password = findViewById(R.id.register_password);
        register_confirm_password = findViewById(R.id.register_confirm_password);
        register_age = findViewById(R.id.register_age);
        register_sssm_id = findViewById(R.id.register_sssm_id);
        register_family_id = findViewById(R.id.register_family_id);
        register_registerbtn = findViewById(R.id.register_registerbtn);
//        female = findViewById(R.id.female);
//        male = findViewById(R.id.male);
        radioGroup=findViewById(R.id.radioGroup);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserInfo");//.child(encode_email);//.child(encodeUserEmail(register_email.toString()));
        userInfo = new UserInfo();



//        if(female.isSelected()){
//            male.setSelected(false);
//        }
//        else if(male.isSelected())
//        {
//            female.setSelected(false);
//        }



        register_registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                RegisterNewUser();
            }
        });
    }

    public void rbclick(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        gender=radioButton.getText().toString();
        Toast.makeText(this, gender,
                Toast.LENGTH_SHORT).show();
    }


    private void RegisterNewUser(){
        String name,email,password,confirm_password,age,sssm_id,family_id;
        name = register_name.getText().toString();
        email = register_email.getText().toString();
        password = register_password.getText().toString();
        confirm_password = register_confirm_password.getText().toString();
        age = register_age.getText().toString();
        sssm_id = register_sssm_id.getText().toString();
        family_id = register_family_id.getText().toString();


        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)|| TextUtils.isEmpty(confirm_password)
                || TextUtils.isEmpty(age)|| TextUtils.isEmpty(sssm_id)|| TextUtils.isEmpty(family_id) || gender.equals("")){
            Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_LONG).show();
            return;
        }
//        if (password != confirm_password){
//            Toast.makeText(getApplicationContext(),"Passwords don't match",Toast.LENGTH_LONG).show();
//            return;
//        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                            FirebaseUser user= mAuth.getCurrentUser();
                            addDatatoFirebase(name,email,password,age,sssm_id,family_id,gender);


                            if(Integer.parseInt(age)<=8) {
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

                                databaseReference2 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(encodeUserEmail(email.toString()));

                                for (int i = 1; i <= 16; i++) {
                                    databaseReference2.child("WeTime").child(""+i).child("Status").setValue("False");
                                    databaseReference2.child("WeTime").child(""+i).child("Description").setValue(wetime[i-1][1]);
                                    databaseReference2.child("WeTime").child(""+i).child("ID").setValue(wetime[i-1][0]);
                                }

                            }

//                            if (Integer.parseInt()<=8) {
                                Intent intent = new Intent(RegisterActivity.this, DashHome_Nur_3.class);
                                startActivity(intent);
//                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Registration failed!!"+ task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void addDatatoFirebase(String name, String email, String password, String age, String sssmid, String familyid, String gender) {
        userInfo.setName(name);
        userInfo.setEmail(email);
        userInfo.setPassword(password);
        userInfo.setage(age);
        userInfo.setSssm_id(sssmid);
        userInfo.setFamily_id(familyid);
        userInfo.setGender(gender);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(encodeUserEmail(email.toString())).child("info").setValue(userInfo);
                databaseReference.child(encodeUserEmail(email.toString())).child("SleepDetails").child("SleepActivity").setValue(true);
                Toast.makeText(RegisterActivity.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RegisterActivity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void movetologin(){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    private String encodeUserEmail(String email) {
        return email.replace(".",",");
    }



}