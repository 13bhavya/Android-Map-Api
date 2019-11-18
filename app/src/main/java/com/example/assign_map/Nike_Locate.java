package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Nike_Locate extends AppCompatActivity {

    public String nike_add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nike__locate);

        Intent i = getIntent();
        nike_add = i.getStringExtra("BRAND");
        Toast.makeText(getApplicationContext(),nike_add,Toast.LENGTH_LONG).show();
        //i.putExtra("BRAND3","Nike");

    }

    public void ClickButton(View view){

        String City = "";

        if (findViewById(R.id.scar) == view){
            City = getString(R.string.scarborough);
        } else if (findViewById(R.id.north) == view){
            City = getString(R.string.northyork);
        } else if (findViewById(R.id.markh) == view){
            City = getString(R.string.markham);
        }

        final String Area = nike_add + " " + City ;

        Intent intent = new Intent(Nike_Locate.this, MapsActivity.class);
        intent.putExtra("Map", Area);
        intent.putExtra("BRAND", nike_add);
        startActivity(intent);
    }
}
