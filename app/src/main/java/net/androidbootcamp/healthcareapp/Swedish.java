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

public class Swedish extends AppCompatActivity {
    TextView web10;
    Button phone10, map10, home10, contact10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swedish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone10=(Button)findViewById(R.id.phone10);

        web10=(TextView)findViewById(R.id.web10);
        //Displays the clinic website
        web10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swedish.org/"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2063203399"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map10 = (Button)findViewById(R.id.map10);
        map10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"3400 California Ave SW, Seattle, WA, 98116");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home10=(Button)findViewById(R.id.home10);
        home10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Swedish.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact10=(Button)findViewById(R.id.contact10);
        contact10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Swedish.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
