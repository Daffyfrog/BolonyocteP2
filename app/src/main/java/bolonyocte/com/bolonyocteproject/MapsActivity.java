package bolonyocte.com.bolonyocteproject;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import bolonyocte.com.bolonyocteproject.Model.ZoneDeVie;
import im.delight.android.location.SimpleLocation;

import static android.graphics.Color.WHITE;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar myToolbar;
    private FloatingSearchView search_bar;
    private ObjectMapper mapper;
    private LocationManager lManager;
    private String mprovider;
    public final int MY_PERMISSIONS_REQUEST_LOCATION = 46;
    private SimpleLocation sLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapper = new ObjectMapper();
        search_bar = (FloatingSearchView) findViewById(R.id.searchBar);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Test");
        myToolbar.setTitleTextColor(WHITE);
        setSupportActionBar(myToolbar);

        sLocation = new SimpleLocation(this);

        // if we can't access the location yet
        if (! sLocation.hasLocationEnabled()) {
            // ask the user to enable location access
            SimpleLocation.openSettings(this);

        }
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }

        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }

        }


        search_bar.setOnSearchListener(new FloatingSearchView.OnSearchListener() {

            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
            }

            @Override
            public void onSearchAction(String currentQuery) {
                onQuery(currentQuery);
            }
        });


        InputStream in = getResources().openRawResource(R.raw.bolonyocte_data_example);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line = null;
        String jsonData = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            line = reader.readLine();
            while (line != null) {
                jsonData += line;
                line = reader.readLine();
            }
            System.out.println(jsonData);

            ZoneDeVie zdv = mapper.readValue(jsonData, ZoneDeVie.class);
            System.out.println(zdv.toString() + ": " + zdv.getCommunes().size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

                System.out.println("OK");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_bar, menu);

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter(this.getApplicationContext()));
    }


    public void onQuery(String query) {
        mMap.clear();
        String location = query;
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!addressList.isEmpty()) {
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            }
            else
            {
                new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertTheme))
                        .setTitle("Aucun résultat")
                        .setMessage("\nVeuillez réessayer")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }

    public void onMapSearch(View view) {
        mMap.clear();
        System.out.println();
        double latitude = sLocation.getLatitude();
        double longitude = sLocation.getLongitude();
        LatLng coords = new LatLng(latitude, longitude);
        if (coords != null) {

            mMap.addMarker(new MarkerOptions().position(coords).title("Marker"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coords, 15));
        }
    }
}
