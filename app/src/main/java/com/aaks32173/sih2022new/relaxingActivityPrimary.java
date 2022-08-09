package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class relaxingActivityPrimary extends AppCompatActivity {

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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://bubblespop.netlify.app/");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://www.digipuzzle.net/main/kids/");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb("https://www.teachingexpertise.com/classroom-ideas/school-scavenger-hunts-for-students/");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotojournalism();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHobbies();
            }
        });

    }
    private void gotoHobbies() {
        Intent intent = new Intent(relaxingActivityPrimary.this, relaxingHobies.class);
        startActivity(intent);
    }
    private void gotojournalism() {
        Intent intent = new Intent(relaxingActivityPrimary.this, relaxingJournaling.class);
        startActivity(intent);
    }

    public void openWeb(String url)
    {
        Intent intent = new Intent(relaxingActivityPrimary.this, webView.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}//ex, hunt riddles, interest, journal, qzs