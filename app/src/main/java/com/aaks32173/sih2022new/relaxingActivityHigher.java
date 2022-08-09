package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class relaxingActivityHigher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxing_higher);
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
                openRiddle();
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
                openWeb("https://in.pinterest.com/search" +
                        "/pins/?q=30%20day%20challenge&rs=srs&b" +
                        "_id=BKORT20M4hhYAAAAAAAAAADnXIsp6DsSY0UNo3OQNu" +
                        "Q7t2ByVfBVszigazLOkmwbcDiU0mJslpJuDGRjfq_U638&source_id" +
                        "=rlp_yG3iVaam");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoexercise();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizzes();
            }
        });

    }

    private void gotoexercise() {
        Intent intent =  new Intent(relaxingActivityHigher.this, flex_time.class);
        startActivity(intent);
    }

    private void openRiddle() {
        Intent intent =  new Intent(relaxingActivityHigher.this, ActivityRiddles.class);
        startActivity(intent);
    }
    private void openQuizzes() {
        Intent intent =  new Intent(relaxingActivityHigher.this, relaxingQuizes.class);
        startActivity(intent);
    }
    private void gotojournalism() {
        Intent intent = new Intent(relaxingActivityHigher.this, relaxingJournaling.class);
        startActivity(intent);
    }
    public void openWeb(String url)
    {
        Intent intent = new Intent(relaxingActivityHigher.this, webView.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}