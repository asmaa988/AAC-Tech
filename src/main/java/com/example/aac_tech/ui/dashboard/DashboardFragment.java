package com.example.aac_tech.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aac_tech.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private DrawerLayout mDrawerLayout;
    private GoogleMap mMap;
    private ArrayList info;
    private Resources res;

    private SupportMapFragment mapFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_maps, container, false);
        Intent intent = getActivity().getIntent();

        info = intent.getStringArrayListExtra("info");
        res = getResources();






        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);



        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {

                    //Containers to store hospital location for display on maps
                    String [] hosp1 = res.getStringArray(R.array.hosp1);
                    String [] hosp2 = res.getStringArray(R.array.hosp2);
                    String [] hosp3 = res.getStringArray(R.array.hosp3);
                    String [] hosp4 = res.getStringArray(R.array.hosp4);
                    String [] hosp5 = res.getStringArray(R.array.hosp5);

                    // Add a marker in Sydney and move the camera
                    LatLng hospital1 = (new LatLng(Float.parseFloat(hosp1[1]), Float.parseFloat(hosp1[2])));
                    googleMap.addMarker(new MarkerOptions().position(hospital1).title(hosp1[3]));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(hospital1));

                    LatLng hospital2 = (new LatLng(Float.parseFloat(hosp2[1]), Float.parseFloat(hosp2[2])));
                    googleMap.addMarker(new MarkerOptions().position(hospital2).title(hosp2[3]));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(hospital2));

                    LatLng hospital3 = (new LatLng(Float.parseFloat(hosp3[1]), Float.parseFloat(hosp3[2])));
                    googleMap.addMarker(new MarkerOptions().position(hospital3).title(hosp3[3]));

                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(hospital3));

                    LatLng hospital4 = (new LatLng(Float.parseFloat(hosp4[1]), Float.parseFloat(hosp4[2])));
                    googleMap.addMarker(new MarkerOptions().position(hospital4).title(hosp4[3]));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(hospital4));

                    LatLng hospital5 = (new LatLng(Float.parseFloat(hosp5[1]), Float.parseFloat(hosp5[2])));
                    googleMap.addMarker(new MarkerOptions().position(hospital5).title(hosp5[3]));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(hospital5));

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hospital1,10.0f));
                }
            });
        }

        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();





        return root;
    }

    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Resources res = getResources();
        //Containers to store hospital location for display on maps
        String [] hosp1 = res.getStringArray(R.array.hosp1);
        String [] hosp2 = res.getStringArray(R.array.hosp2);
        String [] hosp3 = res.getStringArray(R.array.hosp3);
        String [] hosp4 = res.getStringArray(R.array.hosp4);
        String [] hosp5 = res.getStringArray(R.array.hosp5);

        // Add a marker in Sydney and move the camera
        LatLng hospital1 = (new LatLng(Float.parseFloat(hosp1[1]), Float.parseFloat(hosp1[2])));
        mMap.addMarker(new MarkerOptions().position(hospital1).title(hosp1[3]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital1));

        LatLng hospital2 = (new LatLng(Float.parseFloat(hosp2[1]), Float.parseFloat(hosp2[2])));
        mMap.addMarker(new MarkerOptions().position(hospital2).title(hosp2[3]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital2));

        LatLng hospital3 = (new LatLng(Float.parseFloat(hosp3[1]), Float.parseFloat(hosp3[2])));
        mMap.addMarker(new MarkerOptions().position(hospital3).title(hosp3[3]));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital3));

        LatLng hospital4 = (new LatLng(Float.parseFloat(hosp4[1]), Float.parseFloat(hosp4[2])));
        mMap.addMarker(new MarkerOptions().position(hospital4).title(hosp4[3]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital4));

        LatLng hospital5 = (new LatLng(Float.parseFloat(hosp5[1]), Float.parseFloat(hosp5[2])));
        mMap.addMarker(new MarkerOptions().position(hospital5).title(hosp5[3]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital5));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hospital1,10.0f));
    }*/


}