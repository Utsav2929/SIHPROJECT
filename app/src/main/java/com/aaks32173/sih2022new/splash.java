package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class splash extends AppCompatActivity {
    TextView hell,wel ;
    private static int spash_time=6000 ;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = mAuth.getCurrentUser();
        wel=findViewById(R.id.welcome_msg) ;
        hell=findViewById(R.id.hello) ;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(currentuser==null){
                Intent spash=new Intent(splash.this,WelcomeActivity.class) ;

                startActivity(spash);
                finish();}
                else{
                    Intent spash=new Intent(splash.this,DashHome_Nur_3.class) ;

                    startActivity(spash);
                    finish();
                }
            }
        },spash_time) ;
        Animation myanim2= AnimationUtils.loadAnimation(splash.this,R.anim.anim2) ;
        Animation myanim1= AnimationUtils.loadAnimation(splash.this,R.anim.anim1) ;
        wel.startAnimation(myanim2);
        hell.startAnimation(myanim1);
    }
}