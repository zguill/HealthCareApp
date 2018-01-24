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

public class Lenox extends AppCompatActivity {
    TextView web8;
    Button phone6, map6, home6, contact6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone6=(Button)findViewById(R.id.phone6);

        web8=(TextView)findViewById(R.id.web8);
        //Displays the clinic website
        web8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.northwell.edu/find-care/locations/lenox-hill-hospital?utm_source=local_yext&utm_medium=local&utm_campaign=yext"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2124342000"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map6 = (Button)findViewById(R.id.map6);
        map6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"100 E 77th St, New York, NY, 10075");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home6=(Button)findViewById(R.id.home6);
        home6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lenox.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact6=(Button)findViewById(R.id.contact6);
        contact6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Lenox.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
