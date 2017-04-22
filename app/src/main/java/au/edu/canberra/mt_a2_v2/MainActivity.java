package au.edu.canberra.mt_a2_v2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    public locations locations = new locations();
    public PolygonOptions ucArea = new PolygonOptions();
    public GoogleMap ucMap;

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
        ucMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations.UC_StartingLocation, 14.6f));
    }
}
