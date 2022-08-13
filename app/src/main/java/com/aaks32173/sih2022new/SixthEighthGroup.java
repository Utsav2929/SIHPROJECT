package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SixthEighthGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_eighth_group);
        ImageButton menstural = findViewById(R.id.menstural);
        ImageButton relaxing = findViewById(R.id.relaxing);
        ImageButton flextime = findViewById(R.id.flextime);
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
}