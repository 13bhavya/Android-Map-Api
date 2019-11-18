package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Puma_Locate extends AppCompatActivity {

    public String puma_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puma__locate);

        Intent i = getIntent();
        puma_add = i.getStringExtra("BRAND");
        Toast.makeText(getApplicationContext(),puma_add,Toast.LENGTH_LONG).show();
    }

    public void ClickButton(View view) {

        String City = "";

        if (findViewById(R.id.scar) == view) {
            City = getString(R.string.scarborough);
        } else if (findViewById(R.id.north) == view) {
            City = getString(R.string.northyork);
        } else if (findViewById(R.id.markh) == view) {
            City = getString(R.string.markham);
        }

        final String Area = puma_add + " " + City + " " + "ON";

        Intent intent = new Intent(Puma_Locate.this, MapsActivity.class);
        intent.putExtra("Map", Area);
        intent.putExtra("BRAND", puma_add);
        startActivity(intent);
    }
}

