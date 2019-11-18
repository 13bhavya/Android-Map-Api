package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Brand_Activity extends AppCompatActivity {

    RelativeLayout puma, adidas, nike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_);

        puma = findViewById(R.id.rel1);
        adidas = findViewById(R.id.rel2);
        nike = findViewById(R.id.rel3);

        //OnClick Listener to goto specific Brand Activity
        puma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Brand_Activity.this,Puma_Locate.class);
                i.putExtra("BRAND","Puma");
                startActivity(i);
            }
        });
        adidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Brand_Activity.this,Adidas_Locate.class);
                i.putExtra("BRAND","Adidas");
                startActivity(i);
            }
        });
        nike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Brand_Activity.this,Nike_Locate.class);
                i.putExtra("BRAND","Nike");
                startActivity(i);
            }
        });
    }



}
