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

public class Cedars extends AppCompatActivity {
    TextView web4;
    Button phone4, map4, home4, contact4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cedars);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone4=(Button) findViewById(R.id.phone4);

        web4=(TextView)findViewById(R.id.web4);
        //Displays the clinic website
        web4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cedars-sinai.edu/"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:8002332771"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map4 = (Button)findViewById(R.id.map4);
        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"8700 Beverly Blvd, Los Angeles, CA, 90048");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home4=(Button)findViewById(R.id.home4);
        home4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cedars.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact4=(Button)findViewById(R.id.contact4);
        contact4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Cedars.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
