package com.example.assign_map;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    private static final int REQUEST_LOCATION_PERMISSION = 1;

    private Context context;
    public static String MapArea;
    public static String Brand;
    public static String City;

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

        RadioGroup RG = findViewById(R.id.rg_view);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_normal){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                } else if (checkedId == R.id.rb_satellite){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else if (checkedId == R.id.rb_hybrid) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });

        Intent intent = getIntent();
        City = intent.getStringExtra("City");
        MapArea = intent.getStringExtra("Map");
        Brand = intent.getStringExtra("BRAND");

        mapFragment.getMapAsync(this);

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

        final Geocoder coder = new Geocoder(getApplicationContext());

        String placeName = MapArea;

        Toast.makeText(getApplicationContext(),MapArea,Toast.LENGTH_LONG).show();

        mMap.clear();

        try {
            //using geo coder object getting maximum 5 addresses for given place name / address
            List<Address> geocodeResults = coder.getFromLocationName(placeName, 3);
            Iterator<Address> locations = geocodeResults.iterator();

            // get location names and relative address and show them on google map
            String locInfo = "";
            while (locations.hasNext()) {
                Address loc = locations.next();

                LatLng store = new LatLng(loc.getLatitude(), loc.getLongitude());
                int addIdx = loc.getMaxAddressLineIndex();
                for (int idx = 0; idx <= addIdx; idx++) {
                    String addLine = loc.getAddressLine(idx);
                    locInfo = String.format("%s", addLine);
                }

                MarkerOptions markerOptions = new MarkerOptions();
                Marker m1 = mMap.addMarker(new MarkerOptions().
                        position(store)
                        .snippet(Brand)
                        .title(locInfo)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icons8)));

                InfoWindowData info = new InfoWindowData();
                info.setImg("ccc");
                info.setBrand(Brand);
                info.setAddress(locInfo);
                info.setCity(City);
                info.setPhone("986 545 8532");

                CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
                mMap.setInfoWindowAdapter(customInfoWindow);

                m1.setTag(info);
                m1.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store, 12f));
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Failed to get location info " + e, Toast.LENGTH_LONG).show();
        }

    }




}

/*LatLng puma_1 = new LatLng(43.7671904, -79.3584039);
        LatLng puma_2 = new LatLng(43.7349687, -79.3448839);

        //MarkerOptions markerOptions = new MarkerOptions();
        Marker m1 = mMap.addMarker(new MarkerOptions()
                .position(puma_1)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        InfoWindowData info = new InfoWindowData();
        info.setImg("puma_logo.png");
        info.setBrand("" +
                "Puma Showroom" + Final);
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


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puma_1, 12f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puma_2, 12f));

         */

