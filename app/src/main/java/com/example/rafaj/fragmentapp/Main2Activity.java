package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView text;
    TextView text2;
    TextView text3;
    ImageView Photo;
    Bundle bundle;
    Intent a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent callingIntent = getIntent();


        text= findViewById(R.id.textId);
        text2= findViewById(R.id.textId2);
        text3= findViewById(R.id.textId3);
        Photo= findViewById(R.id.Img);

        bundle= getIntent().getExtras();
        a= getIntent();


        text.setText(bundle.getString("KEY"));
        text2.setText(bundle.getString("KEY2"));
        text3.setText(bundle.getString("KEY3"));
        Photo.setImageResource(a.getIntExtra("Photo",0));


         String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();



        }

    }


