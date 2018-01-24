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

public class Polyclinic extends AppCompatActivity {
    TextView web2;
    Button phone8, map8, home8, contact8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyclinic);
        phone8=(Button)findViewById(R.id.phone8);

        web2=(TextView)findViewById(R.id.web2);
        //Displays the clinic website
        web2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://polyclinic.com/"));
                    startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2063221211"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map8 = (Button)findViewById(R.id.map8);
        map8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"2902 Beacon Ave S, Seattle, WA, 98144");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home8=(Button)findViewById(R.id.home8);
        home8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Polyclinic.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact8=(Button)findViewById(R.id.contact8);
        contact8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Polyclinic.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
