package com.aaks32173.sih2022new;

import androidx.appcompat.app.AppCompatActivity;
import com.aaks32173.sih2022new.ui.MainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
public class fouthFifthGroup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouth_fifth_group);
        ImageButton button5=(ImageButton)findViewById(R.id.imageButton5);
        ImageButton music = findViewById(R.id.music);
        ImageButton podcasts = findViewById(R.id.podcasts);
        ImageButton gtbt = findViewById(R.id.gtbt);
        ImageButton relaxing = findViewById(R.id.relaxing);
        ImageButton menstural = findViewById(R.id.menstural);
        ImageButton chatbot = findViewById(R.id.chatbot);
        ImageButton post =findViewById(R.id.post);
        gtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGtbt();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetoflextime();
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusic();
            }
        });
        podcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPodcasts();
            }
        });
        relaxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoRelaxing();
            }
        });
        menstural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoMenstural();
            }
        });
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoBot();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowpost();
            }
        });
    }
    private void openShowpost() {
        Intent intent = new Intent(fouthFifthGroup.this, Showpost.class);
        startActivity(intent);
    }
    private void openGtbt() {
        Intent intent = new Intent(fouthFifthGroup.this, gtbtPanelFourthFifth.class);
        startActivity(intent);
    }
    private void openMusic() {
            Intent intent = new Intent(fouthFifthGroup.this, MusicPlayer.class);
            intent.putExtra("path", "MusicFourthFifth");
            startActivity(intent);
    }
    private void openPodcasts() {
        Intent intent = new Intent(fouthFifthGroup.this, podcasts.class);
        intent.putExtra("group", "FourthFifth");
        startActivity(intent);
    }
    private void movetoflextime() {
        Intent intent = new Intent(fouthFifthGroup.this, flextimefourthfifth.class);
        startActivity(intent);
    }
    private void movetoRelaxing() {
        Intent intent = new Intent(fouthFifthGroup.this, relaxingActivityPrimary.class);
        startActivity(intent);
    }
    private void movetoMenstural() {
        Intent intent = new Intent(fouthFifthGroup.this, MensturalFourthFifthGroup.class);
        startActivity(intent);
    }
    private void movetoBot() {
        Intent intent = new Intent(fouthFifthGroup.this, com.aaks32173.sih2022new.ui.MainActivity.class);
        startActivity(intent);
    }
}