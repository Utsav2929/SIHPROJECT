package com.aaks32173.sih2022new;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class chekk extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private RecyclerView.Adapter adapter ;
    private List<listitem>listitems ;
    private Button btn ;
    private String si ;
    private EditText editText ;
    private static String URL_DATA ;

    private static String URL_DATA1=" https://api.nutritionix.com/v1_1/search/" ;
           private static String URL_DATA2= "?results=0:20&fields=item_name,brand_name,item_id,nf_calories&appId=26e9d7d4&appKey=470cf8906c9bcf28bbffec8d6bede0ee" ;



    DatabaseReference dbref;
    DatabaseReference dbref2;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    String email;
    TextView showCalories;
    double calories=0.0;
    public double height=0.0;
    public double weight=0.0;
    public double age_id=0.0;
    ImageView imageView;

    public MyAdapter.onItemClickListener listener;
    EditText show;
    Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chekk);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerv) ;
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        editText=findViewById(R.id.search) ;
        btn=findViewById(R.id.searchbtn) ;
        listitems=new ArrayList<>() ;

        mAuth = FirebaseAuth.getInstance();
        currentUser= mAuth.getCurrentUser();
        email = currentUser.getEmail();
        showCalories = findViewById(R.id.showCalories);
        show=findViewById(R.id.diet_show);
        submit=findViewById(R.id.diet_submit);
        imageView = findViewById(R.id.imageView);


        dbref = FirebaseDatabase.getInstance().getReference("UserInfo").child(encodeUserEmail(email)).child("BMI");
        dbref.child("height").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                height = Double.parseDouble((String) snapshot.getValue());
                dbref.child("weight").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        weight =Double.parseDouble((String) snapshot.getValue());
//                Toast.makeText(getApplicationContext(), Double.toString( weight), Toast.LENGTH_SHORT).show();
                        dbref2= FirebaseDatabase.getInstance().getReference("UserInfo").child(encodeUserEmail(email)).child("age");
                        dbref2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                age_id= Double.parseDouble((String)snapshot.getValue());
                                double height_inch=height*100.0*0.394;
                                double weight_pounds = weight*2.205;
//                                Toast.makeText(getApplicationContext(), "heigth "+height, Toast.LENGTH_SHORT).show();
//                                //+"weight "+weight_pounds
                                calories = ((height_inch*4.7)+(weight_pounds*4.35)-(age_id*4.7))*1.35;
                                int a= (int) Math.round(calories);
                                String cc = Integer.toString(a);
                                showCalories.setText(cc);



                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitems.clear();
                 si=editText.getText().toString();
                loadRecyclerviewData() ;

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(chekk.this,show.getText(),Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),"Calories "+(showCalories.getText().toString()),Toast.LENGTH_SHORT).show();
                Double p=Double.parseDouble(showCalories.getText().toString()) - Double.parseDouble(show.getText().toString());
//               int diet=Integer.parseInt(showCalories.getText().toString());
//               int ttldiet= Integer.parseInt(show.getText().toString());
//
//                Toast.makeText(chekk.this,diet, Toast.LENGTH_SHORT).show();
//
//                Toast.makeText(chekk.this, ttldiet, Toast.LENGTH_SHORT).show();

//               increasecounter(email,diet,ttldiet);

                if(p<0.0d) {
                    Toast.makeText(chekk.this, "Calorie Intake Achieved", Toast.LENGTH_SHORT).show();
                    showCalories.setText("0");
                    show.setText("");
                    editText.setText("");
                    listitems.clear();
                    loadRecyclerviewData() ;
                }else
                {
                    showCalories.setText(p.toString());
                    show.setText("");
                    editText.setText("");
                    listitems.clear();
                    loadRecyclerviewData() ;
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chekk.this,Diett.class);
                startActivity(intent);
            }
        });


    }
    private void loadRecyclerviewData()
    {
        URL_DATA=URL_DATA1+si+URL_DATA2;
//        Toast.makeText(this,URL_DATA,Toast.LENGTH_SHORT).show();
        ProgressDialog progressDialog=new ProgressDialog(this) ;
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                    progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(s) ;
                    JSONArray array=jsonObject.getJSONArray("hits")    ;

                     for (int i=0;i<array.length();i++)
                     {
                         JSONObject o=array.getJSONObject(i) ;

                         String fild=o.getString("fields");
//                         Toast.makeText(getApplicationContext(),fild,Toast.LENGTH_SHORT).show();

                         JSONObject fldfinal=new JSONObject(fild) ;
                         listitem item=new listitem(fldfinal.getString("item_name"),fldfinal.getString("nf_calories")) ;



                        listitems.add(item) ;
                     }



//                        for(int j=0;j<p.length();j++){
//                            JSONObject ff=p.getJSONObject(j) ;
//                            listitem item=new listitem(ff.getString("item_name"),ff.getString("item_id")) ;
//                            listitems.add(item) ;
//
//                        }


                    SetOnClickListener();
                     adapter= new MyAdapter(listitems,listener) ;
                     recyclerView.setAdapter(adapter);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(chekk.this));


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }) ;

        RequestQueue requestQueue= Volley.newRequestQueue(this) ;
        requestQueue.add(stringRequest);
    }

    private void SetOnClickListener() {
        listener = new MyAdapter.onItemClickListener(){
            @Override
            public void onClickItem(View v, int positon) {
//                Toast.makeText(getApplicationContext(),"item "+positon,Toast.LENGTH_SHORT).show();

                show.setText(listitems.get(positon).getCal());
//                                recyclerView.setVisibility(View.INVISIBLE);
            }
        };
    }


    private String encodeUserEmail(String email) {
        return email.replace(".", ",");
    }




    private void increasecounter(String email,int diet,int ttldiet) {
        LocalDate today=LocalDate.now();

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(email).child("TODO").child(today.toString());
        reference1.addListenerForSingleValueEvent(new ValueEventListener() {
            String progress;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progress = dataSnapshot.child("nutrition").child("progress").getValue().toString();

                    int prg=(ttldiet/diet)*100;

                reference1.child("nutrition").child("progress").setValue(Integer.toString(prg));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

}