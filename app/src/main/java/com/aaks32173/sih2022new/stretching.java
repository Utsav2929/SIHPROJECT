package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stretching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        String videoUrl="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fstretchings%2Fstretching%203.mp4?alt=media&token=75496b2b-e45e-4bad-b4ee-450157f2d090";
        String videoUrl2="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fstretchings%2Fstretching%204.mp4?alt=media&token=57c2fe46-663c-49a9-a758-45c4c981c89f";
        String videoUrl3="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fstretchings%2Fstrtching%20exercises%202_Trim.mp4?alt=media&token=625e8cd6-a419-43da-9a82-305e8b037a68";
        String videoUrl4="https://firebasestorage.googleapis.com/v0/b/sih2022-15182.appspot.com/o/exercises%2Fstretchings%2Fstrteching%20exercises1.mp4?alt=media&token=0c1a2832-3759-4751-8f3a-d8cf3a78d7b2";
        String videoUrl5="";
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioPlayer(videoUrl);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioPlayer(videoUrl2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioPlayer(videoUrl3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioPlayer(videoUrl4);
            }
        });
    }
    private void vedioPlayer(String url){
        Intent intent = new Intent(this,vedioPlay.class);
        intent.putExtra("url", url);
        intent.putExtra("nxt", "stretching");
        startActivity(intent);

    }
}