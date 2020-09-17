package com.example.alumnismartconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button btnEvents;
    Button btnCareeropportunities;
    Button btnGallery;
    Button btnEditprofiledetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnEvents= findViewById(R.id.btnEvents);
        Button btnCareerOpportunities= findViewById(R.id.btnCareeropportunities);
        Button btnGallery= findViewById(R.id.btnGallery);
        Button btnEditProfileDetails= findViewById(R.id.btnEditprofiledetails);

        btnEvents.setOnClickListener(this);
        btnCareerOpportunities.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnEditProfileDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnEvents){
            Intent intent=new Intent(this,Events.class);
            startActivity(intent);

        }else if (v.getId()==R.id.btnCareeropportunities){
            Intent intent=new Intent(this,CareerOpportunities.class);
            startActivity(intent);

        }else if (v.getId()==R.id.btnGallery){
            Intent intent=new Intent(this,Gallery.class);
            startActivity(intent);

        }else if (v.getId()==R.id.btnEditprofiledetails){
            Intent intent=new Intent(this,EditProfileDetails.class);
            startActivity(intent);
        }

    }
}
