package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class flex_time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_time);
        ImageButton yoga = findViewById(R.id.yogabtn);
        ImageButton workout = findViewById(R.id.workoutbtn);
        ImageButton stretching = findViewById(R.id.stretchingbth);
        ImageButton meditation = findViewById(R.id.meditationbtn);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openyogas();
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openworkouts();
            }
        });
        stretching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstrerchings();
            }
        });
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmeditations();
            }
        });
    }
    private void openyogas(){
        Intent intent = new Intent(this,yoga.class);
        startActivity(intent);

    }
    private void openworkouts(){
        Intent intent = new Intent(this,workout.class);
        startActivity(intent);

    }
    private void openstrerchings(){
        Intent intent = new Intent(this,stretching.class);
        startActivity(intent);

    }
    private void openmeditations(){
        Intent intent = new Intent(this,meditation.class);
        startActivity(intent);

    }
}