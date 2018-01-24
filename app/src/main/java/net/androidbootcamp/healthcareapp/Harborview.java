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

public class Harborview extends AppCompatActivity {

    TextView web1;
    Button phone5, map5, home5, contact5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harborview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone5 = (Button)findViewById(R.id.phone5);

        web1=(TextView)findViewById(R.id.web1);
        //Displays the clinic website
        web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uwmedicine.org/harborview"));
                startActivity(browswerIntent);
            }
        });
        // Connects to phone allowing user to call out
        phone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2067443000"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map5 = (Button)findViewById(R.id.map5);
        map5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"325 9th Ave, Seattle, WA, 98104");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home5=(Button)findViewById(R.id.home5);
        home5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Harborview.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact5=(Button)findViewById(R.id.contact5);
        contact5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Harborview.this, Contacts.class);
                startActivity(intent);
            }
        });



    }

}
