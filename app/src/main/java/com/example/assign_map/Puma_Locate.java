package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Puma_Locate extends AppCompatActivity {

    TextView Scar, North, Markham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puma__locate);

        Scar = findViewById(R.id.scar);
        North = findViewById(R.id.northyork);
        Markham = findViewById(R.id.markham);


    }

    public void Scarboro(View view){

        Intent i = new Intent(Puma_Locate.this,MapsActivity.class);
        startActivity(i);
    }

}
