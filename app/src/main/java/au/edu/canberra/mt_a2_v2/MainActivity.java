package au.edu.canberra.mt_a2_v2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    public locations locations = new locations();
    public PolygonOptions ucArea = new PolygonOptions();
    public GoogleMap ucMap;
    public markerOptions markerOps = new markerOptions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_normal:
                ucMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.action_hybrid:
                ucMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.action_satellite:
                ucMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.action_terrain:
                ucMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.action_none:
                ucMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;

        }
        return true;
    }

    public void onMapReady(GoogleMap map) {
        ucMap = map;
        ucArea.add(new LatLng(-35.2314688, 149.0808584),
                new LatLng(-35.2318777, 149.0837664),
                new LatLng(-35.2338154, 149.0872369),
                new LatLng(-35.2344526, 149.0894986),
                new LatLng(-35.234921, 149.0916533),
                new LatLng(-35.2385119, 149.0903422),
                new LatLng(-35.239973, 149.0900189),
                new LatLng(-35.2409119, 149.0899526),
                new LatLng(-35.2419054, 149.0900632),
                new LatLng(-35.2423299, 149.0880429),
                new LatLng(-35.2422903, 149.0780278),
                new LatLng(-35.2411716, 149.0756792),
                new LatLng(-35.2406632, 149.0753558),
                new LatLng(-35.238251, 149.0769211),
                new LatLng(-35.2355958, 149.0778606),
                new LatLng(-35.232333, 149.0800329)
        );
        ucArea.fillColor(0x2366dbff);
        ucArea.strokeColor(0xffc7fcff);
        ucArea.strokeWidth(4);
        ucArea.clickable(true);
        ucMap.addPolygon(ucArea);

        markerOps.alpha = 1f;
        markerOps.draggable = false;
        markerOps.flat = false;

        MarkerOptions marker_StudentCenter = new MarkerOptions();
            marker_StudentCenter.position(locations.UC_StudentCenter);
            marker_StudentCenter.title("UC Student Center");
            marker_StudentCenter.snippet("Your gateway to access support and advice");
            marker_StudentCenter.alpha(markerOps.alpha);
            marker_StudentCenter.icon(BitmapDescriptorFactory.fromResource(R.drawable.student));
            marker_StudentCenter.draggable(markerOps.draggable);
            marker_StudentCenter.flat(markerOps.flat);

        MarkerOptions marker_CoffeeGrounds = new MarkerOptions();
            marker_CoffeeGrounds.position(locations.UC_CoffeeGrounds);
            marker_CoffeeGrounds.title("Coffee Grounds");
            marker_CoffeeGrounds.snippet("The Best Coffee on campus, underneath Cooper Lodge.");
            marker_CoffeeGrounds.alpha(markerOps.alpha);
            marker_CoffeeGrounds.icon(BitmapDescriptorFactory.fromResource(R.drawable.coffee));
            marker_CoffeeGrounds.draggable(markerOps.draggable);
            marker_CoffeeGrounds.flat(markerOps.flat);

        MarkerOptions marker_Library = new MarkerOptions();
            marker_Library.position(locations.UC_Library);
            marker_Library.title("UC Library");
            marker_Library.snippet("24 Hr access for all students and staff.");
            marker_Library.alpha(markerOps.alpha);
            marker_Library.icon(BitmapDescriptorFactory.fromResource(R.drawable.uclibrary));
            marker_Library.draggable(markerOps.draggable);
            marker_Library.flat(markerOps.flat);

        MarkerOptions marker_Hub = new MarkerOptions();
            marker_Hub.position(locations.UC_Hub);
            marker_Hub.title("The Hub");
            marker_Hub.snippet("Below Concourse level between Building 1 and Building 8.");
            marker_Hub.alpha(markerOps.alpha);
            marker_Hub.icon(BitmapDescriptorFactory.fromResource(R.drawable.the_hub));
            marker_Hub.draggable(markerOps.draggable);
            marker_Hub.flat(markerOps.flat);

        MarkerOptions marker_Gym = new MarkerOptions();
            marker_Gym.position(locations.UC_Gym);
            marker_Gym.title("UC Gym");
            marker_Gym.snippet("Open to students, staff, and the general public.");
            marker_Gym.alpha(markerOps.alpha);
            marker_Gym.icon(BitmapDescriptorFactory.fromResource(R.drawable.gym));
            marker_Gym.draggable(markerOps.draggable);
            marker_Gym.flat(markerOps.flat);

        MarkerOptions marker_MainParking = new MarkerOptions();
            marker_MainParking.position(locations.UC_MainParking);
            marker_MainParking.title("Main Parking area");
            marker_MainParking.snippet("Several hundred parks available");
            marker_MainParking.alpha(markerOps.alpha);
            marker_MainParking.icon(BitmapDescriptorFactory.fromResource(R.drawable.parking));
            marker_MainParking.draggable(markerOps.draggable);
            marker_MainParking.flat(markerOps.flat);

        MarkerOptions marker_NATSEM = new MarkerOptions();
            marker_NATSEM.position(locations.UC_NATSEM);
            marker_NATSEM.title("NATSEM Centre");
            marker_NATSEM.snippet("The National Center for Social and Economic Modeling.");
            marker_NATSEM.alpha(markerOps.alpha);
            marker_NATSEM.icon(BitmapDescriptorFactory.fromResource(R.drawable.natsem));
            marker_NATSEM.draggable(markerOps.draggable);
            marker_NATSEM.flat(markerOps.flat);

        MarkerOptions marker_Peg1 = new MarkerOptions();
            marker_Peg1.position(locations.UC_Peg1);
            marker_Peg1.alpha(markerOps.alpha);
            marker_Peg1.icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman));
            marker_Peg1.draggable(markerOps.draggable);
            marker_Peg1.flat(markerOps.flat);

        MarkerOptions marker_Peg2 = new MarkerOptions();
            marker_Peg2.position(locations.UC_Peg2);
            marker_Peg2.alpha(markerOps.alpha);
            marker_Peg2.icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman));
            marker_Peg2.draggable(markerOps.draggable);
            marker_Peg2.flat(markerOps.flat);

        ucMap.addMarker(marker_StudentCenter);
        ucMap.addMarker(marker_CoffeeGrounds);
        ucMap.addMarker(marker_Library);
        ucMap.addMarker(marker_Hub);
        ucMap.addMarker(marker_Gym);
        ucMap.addMarker(marker_MainParking);
        ucMap.addMarker(marker_NATSEM);
        ucMap.addMarker(marker_Peg1);
        ucMap.addMarker(marker_Peg2);

        ucMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations.UC_StartingLocation, 14.6f));

        ucMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(final Polygon polygon) {
                Toast.makeText(getApplicationContext(), "University of Canberra", Toast.LENGTH_SHORT).show();
                polygon.setFillColor(Color.argb(70, 200, 13, 0));
                polygon.setStrokeColor(Color.BLACK);
            }
        });

        ucMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast toast = Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT);
            }
        });

        ucMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

            }
        });
    }

    public void gotoStreetView(){startActivity(new Intent(this, StreetView.class));}
}

class markerOptions{
    float alpha;
    boolean draggable;
    boolean flat;
}