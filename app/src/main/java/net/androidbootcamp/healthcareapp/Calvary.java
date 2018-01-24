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

public class Calvary extends AppCompatActivity {
    TextView web6;
    Button phone3, map3, home3, contact3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calvary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone3=(Button) findViewById(R.id.phone3);

        web6=(TextView)findViewById(R.id.web6);
        //Displays the clinic website
        web6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calvaryhospital.org/site/pp.asp?c=ktJUJ9MPIsE&b=3226167"));
                startActivity(browswerIntent);

            }
        });
        // Connects to phone allowing user to call out
        phone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:7185182000"));
                startActivity(callIntent);
            }
        });
        //Connects to GoogleMaps to find address and directions from location
        map3 = (Button)findViewById(R.id.map3);
        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/"+"1740 Eastchester Rd, New York, NY, 10461");
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });
        //Directs user back to main page
        home3=(Button)findViewById(R.id.home3);
        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calvary.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to contact page
        contact3=(Button)findViewById(R.id.contact3);
        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Calvary.this, Contacts.class);
                startActivity(intent);
            }
        });
    }

}
