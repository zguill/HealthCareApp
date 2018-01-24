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

public class Bethany extends AppCompatActivity {
    TextView web7;
    Button phone2, map2, home2, contact2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bethany);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone2=(Button)findViewById(R.id.phone2);
        web7=(TextView)findViewById(R.id.web7);
        //Displays the clinic website
        web7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bmcofny.com/"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:6073536772"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map2 = (Button)findViewById(R.id.map2);
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"222 E 31st #1r, New York, NY, 10016");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home2=(Button)findViewById(R.id.home2);
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bethany.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact2=(Button)findViewById(R.id.contact2);
        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Bethany.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
