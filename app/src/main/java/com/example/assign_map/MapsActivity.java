package com.example.assign_map;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    //private Marker marker_1;

    //mMap = googleMap;

    private static final int REQUEST_LOCATION_PERMISSION = 1;

    private Context context;


    public MapsActivity(Context ctx) {
        context = ctx;
    }

    public MapsActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        /*if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            Toast.makeText(MapsActivity.this,"Request denied",Toast.LENGTH_LONG).show();
            // Show rationale and request permission.
        }*/
        mapFragment.getMapAsync(this);

        Intent i = getIntent();

        //Toast.makeText(getApplicationContext(),i.getStringExtra("dfg"),Toast.LENGTH_LONG).show();

        if (Objects.equals(i.getStringExtra("BRAND3"), i.getStringExtra("SCAR"))){
            Toast.makeText(getApplicationContext(),"" + i.getStringExtra
                    ("BRAND3") + i.getStringExtra("SCAR"),Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),"Brand3 + Scar",Toast.LENGTH_LONG).show();



            LatLng puma_1 = new LatLng(43.7671904, -79.3584039);
            LatLng puma_2 = new LatLng(43.7349687, -79.3448839);

            //MarkerOptions markerOptions = new MarkerOptions();
            Marker m1 = mMap.addMarker(new MarkerOptions()
                    .position(puma_1)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            InfoWindowData info = new InfoWindowData();
            info.setImg("puma_logo.png");
            info.setBrand("Puma Showroom");
            info.setAddress("Foot Locker, 1800 Sheppard Ave E Space 1051,  ON M2J 5A7");
            info.setCity("North York");
            info.setPhone("986 545 8532");



            CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m2 = mMap.addMarker(new MarkerOptions()
                    .position(puma_2)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            InfoWindowData info1 = new InfoWindowData();
            info1.setImg("k");
            info1.setBrand("Puma Showroom");
            info1.setAddress("1 Eglinton Square Bl, Unit 55, Toronto, ON M1L 2K1");
            info1.setCity("Eglinton");
            info1.setPhone("(416) 751-9264");



            CustomInfoWindowGoogleMap customInfoWindow1 = new CustomInfoWindowGoogleMap(this);
            mMap.setInfoWindowAdapter(customInfoWindow1);

            m1.setTag(info);
            m1.showInfoWindow();

            m2.setTag(info1);
            m2.showInfoWindow();

            //Marker m = mMap.addMarker(markerOptions);


            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puma_1,12f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puma_2,12f));

        } else if(Objects.equals(i.getStringExtra("BRAND2"), i.getStringExtra("BRAND2"))){
            Toast.makeText(getApplicationContext(),"" + i.getStringExtra
                    ("BRAND2") + i.getStringExtra("NORTH"),Toast.LENGTH_LONG).show();

        } else if(Objects.equals(i.getStringExtra("BRAND1"), i.getStringExtra("BRAND1"))){
            Toast.makeText(getApplicationContext(),"" + i.getStringExtra
                    ("BRAND1") + i.getStringExtra("MARKHAM"),Toast.LENGTH_LONG).show();
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

        enableMyLocation();
        //mMap.setMinZoomPreference(5);



        //mMap.setMyLocationEnabled(true);
        //mMap.getUiSettings().setMyLocationButtonEnabled(true);






    }
       /* // Add a marker in Sydney and move the camera
        LatLng nik = new LatLng(43.777748, -79.344498);
        mMap.addMarker(new MarkerOptions()
                .position(nik)
                .title("Nikee")
                .snippet("Cloth Branding")
                .alpha(0.7f)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .flat(false));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nik,13f));

        mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {

                if(marker.equals(marker_1)){
                    Log.w("Click", "test");
                    return true;
                }
                return false;
            }
        });*/

       /*
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.custominfowindow, null);

        TextView brand_tv = view.findViewById(R.id.brand_name);
        TextView city_tv = view.findViewById(R.id.city);
        ImageView img = view.findViewById(R.id.pic);

        TextView address_tv = view.findViewById(R.id.address);
        TextView phone_tv = view.findViewById(R.id.phone);

        name_tv.setText(marker.getTitle());
        details_tv.setText(marker.getSnippet());

        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImage().toLowerCase(),
                "drawable", context.getPackageName());
        img.setImageResource(imageId);

        hotel_tv.setText(infoWindowData.getHotel());
        food_tv.setText(infoWindowData.getFood());
        transport_tv.setText(infoWindowData.getTransport());
        return null;

        */
}


