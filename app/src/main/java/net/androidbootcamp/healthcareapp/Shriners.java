package net.androidbootcamp.healthcareapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shriners extends AppCompatActivity {
    TextView web5;
    Button phone9, map9, home9, contact9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shriners);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone9=(Button)findViewById(R.id.phone9);

        web5=(TextView)findViewById(R.id.web5);
        //Displays the clinic website
        web5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shrinershospitalsforchildren.org/Locations/losangeles"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2133383151"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map9 = (Button)findViewById(R.id.map9);
        map9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"3160 Geneva St, Los Angeles, CA, 90020");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home9=(Button)findViewById(R.id.home9);
        home9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shriners.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact9=(Button)findViewById(R.id.contact9);
        contact9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Shriners.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
