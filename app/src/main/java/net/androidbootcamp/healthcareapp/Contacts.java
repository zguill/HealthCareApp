package net.androidbootcamp.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Contacts extends AppCompatActivity {
    Button home11, extramap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Directs user back to main page
        home11=(Button)findViewById(R.id.home11);
        home11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contacts.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Directs user to a map
        extramap=(Button)findViewById(R.id.extramap);
        extramap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Contacts.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }

}
