package net.androidbootcamp.healthcareapp;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStreamReader;
import java.util.jar.Attributes;

public class Angeles extends AppCompatActivity {
    TextView web3;
    Button phone1, map1, home1, contact1;
    TextView textFav, FT1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angeles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        phone1=(Button)findViewById(R.id.phone1);


        //Displays the clinic website
        web3 = (TextView) findViewById(R.id.web3);
        web3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://drmobassermd.com/"));
                startActivity(browswerIntent);

            }
        });



        // Connects to phone allowing user to call out
        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2134574000"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map1 = (Button)findViewById(R.id.map1);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"3160 Geneva St, Los Angeles, CA, 90020");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home1=(Button)findViewById(R.id.home1);
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Angeles.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact1=(Button)findViewById(R.id.contact1);
        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Angeles.this, Contacts.class);
                startActivity(intent);
            }
        });





    }

}



