package net.androidbootcamp.healthcareapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fav_Fragment extends Fragment {
    TextView TF1;
    ListView list1;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the layout for fragment
        View view;
        view = inflater.inflate(R.layout.fragment_fav_,container,false);

        //Fills the listView
        String[] Items = {"Angeles Medical Center", "Polyclinic", "Bethany Medical Clinic", "Lenox Hill"};

        ListView listView = (ListView)view.findViewById(R.id.list1);

        ArrayAdapter<String>listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, Items
        );

        listView.setAdapter(listViewAdapter);
        //Connects the list items to their activities
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(getActivity(), Angeles.class);
                                startActivity(intent);
                        break;
                    case 1:
                        Intent intent1= new Intent(getActivity(), Polyclinic.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), Bethany.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), Lenox.class);
                        startActivity(intent3);
                        break;
                }

                }
        });


        return view;


        }

}
