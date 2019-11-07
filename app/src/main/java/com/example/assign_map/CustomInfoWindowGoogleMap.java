package com.example.assign_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowGoogleMap(Context ctx){
        context= ctx;
    }

   /*cted void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custominfowindow);

    }*/




    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.custominfowindow,null);

        TextView brand_Name = view.findViewById(R.id.brand_name);
        TextView City = view.findViewById(R.id.city);
        ImageView img = view.findViewById(R.id.pic);

        TextView Address = view.findViewById(R.id.address);
        TextView Phone = view.findViewById(R.id.phone);

        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImg().toLowerCase(),
                "puma_logo.png", context.getPackageName());
        img.setImageResource(imageId);

        brand_Name.setText(infoWindowData.getBrand());
        City.setText(infoWindowData.getCity());
        Address.setText(infoWindowData.getAddress());
        Phone.setText(infoWindowData.getPhone());

        return view;
    }
}
