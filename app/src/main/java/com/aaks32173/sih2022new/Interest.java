package com.aaks32173.sih2022new;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class Interest extends AppCompatActivity implements QuantityListener {

    RecyclerView recyler_view ;
    QuantityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        recyler_view=findViewById(R.id.recyler_view) ;
        setRecyclerView() ;
        Button button=(Button)findViewById(R.id.next_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetohome();
            }
        });
    }

    private void movetohome() {

        Intent intent = new Intent(Interest.this, Dash_home.class);
        startActivity(intent);
    }


    private ArrayList<String> getQuantityData(){
        ArrayList<String> arrayList = new ArrayList<>() ;
        arrayList.add("Workout and Exercise");
        arrayList.add("Dance");
        arrayList.add("Indoor Games");
        arrayList.add("Art & Sketching");
        arrayList.add("Reading Books");
        arrayList.add("Sports");
        arrayList.add("Music");
        arrayList.add("Travelling");
        arrayList.add("Yoga & Meditation");

        return arrayList ;
    }
    private void setRecyclerView() {
        recyler_view.setHasFixedSize(true);
        recyler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter=new QuantityAdapter(this,getQuantityData(),this) ;
        recyler_view.setAdapter(adapter);
    }

    @Override
    public void onQuantityChange(ArrayList<String> arrayList) {
        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();
    }
}