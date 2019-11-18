package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Adidas_Locate extends AppCompatActivity {

    public String adidas_add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adidas__locate);

        //Get String from previous Activity and Toast it
        Intent i = getIntent();
        adidas_add = i.getStringExtra("BRAND");
        Toast.makeText(getApplicationContext(),adidas_add,Toast.LENGTH_LONG).show();

    }

    // OnClick Function to goto MapActivity
    public void ClickButton(View view){

        String City = "";

        //Checks which city has been clicked, then pass City name
        if (findViewById(R.id.scar) == view){
            City = getString(R.string.scarborough);
        } else if (findViewById(R.id.north) == view){
            City = getString(R.string.northyork);
        } else if (findViewById(R.id.markh) == view){
            City = getString(R.string.markham);
        }

        final String Area = adidas_add + " " + City ;

        //Next Activity with PutExtra data.
        Intent intent = new Intent(Adidas_Locate.this, MapsActivity.class);
        intent.putExtra("City",City);
        intent.putExtra("Map", Area);
        intent.putExtra("BRAND", adidas_add);
        startActivity(intent);
    }
}
