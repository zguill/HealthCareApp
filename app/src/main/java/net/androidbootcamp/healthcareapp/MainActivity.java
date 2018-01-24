package net.androidbootcamp.healthcareapp;

import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import static net.androidbootcamp.healthcareapp.R.drawable.healthcare;

public class MainActivity extends AppCompatActivity {

    EditText search;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
    HealthClinic healthclinic;
    Button button, fav;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (EditText)findViewById(R.id.search);
        text1 = (TextView) findViewById(R.id.text1);
        text2 =(TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        text6 = (TextView)findViewById(R.id.text6);
        text7 = (TextView)findViewById(R.id.text7);
        text8 = (TextView)findViewById(R.id.text8);
        text9 = (TextView)findViewById(R.id.text9);
        text10 = (TextView)findViewById(R.id.text10);
        button = (Button)findViewById(R.id.button);




        //Displays clinics in the city chosen and connects to their individual clinic activities
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

            if (search.getText().toString().equals("Seattle"))
            {
                text1.setText("Harborview");
                    text1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(MainActivity.this, Harborview.class);
                            startActivity(intent);
                        }
                    });
                text2.setText("Polyclinic");
                    text2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(MainActivity.this, Polyclinic.class);
                        startActivity(intent);
                    }
                });

                text3.setText("Swedish");
                    text3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, Swedish.class);
                            startActivity(intent);
                        }
                    });
            }
            else if (search.getText().toString().equals("Los Angeles"))
               {
                   text4.setText("Cedars Sinai");
                         text4.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Cedars.class);
                           startActivity(intent);
                       }
                   });
                   text5.setText("Angeles Medical Clinic");
                         text5.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Angeles.class);
                           startActivity(intent);
                       }
                   });
                   text6.setText("Shriners Hospital for Children");
                        text6.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Shriners.class);
                           startActivity(intent);
                       }
                   });

               }
            else if (search.getText().toString().equals("New York"))
               {
                   text7.setText("City MD");
                        text7.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, MD.class);
                           startActivity(intent);
                       }
                   });
                   text8.setText("Bethany Medical Clinic");
                        text8.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Bethany.class);
                           startActivity(intent);
                       }
                   });
                   text9.setText("Lenox Hill");
                        text9.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Lenox.class);
                           startActivity(intent);
                       }
                   });
                   text10.setText("Calvary");
                         text10.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent intent = new Intent(MainActivity.this, Calvary.class);
                           startActivity(intent);
                       }
                   });
               }

           }

       });
        //Connects to fragment
        fav=(Button)findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Fav_Fragment FF=new Fav_Fragment();
                fragmentTransaction.add(R.id.favFrag,FF);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }




}





