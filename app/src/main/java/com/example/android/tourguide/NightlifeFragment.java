package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightlifeFragment extends Fragment {


    public NightlifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Lola Lo", R.string.lola_lo));
        locations.add(new Location("China White", R.string.chinawhite));
        locations.add(new Location("Gorilla", R.string.gorilla));
        locations.add(new Location("Revolucion de Cuba", R.string.revolucion_cuba));
        locations.add(new Location("The Deaf Institute", R.string.the_deaf_institute));
        locations.add(new Location("Hidden", R.string.hidden));
        locations.add(new Location("The Warehouse Project", R.string.warehouse_project));
        locations.add(new Location("Factory", R.string.factory_manchester));
        locations.add(new Location("O2 Ritz", R.string.o2_ritz));
        locations.add(new Location("Ford Madox Brown", R.string.ford_madox_brown));
        locations.add(new Location("Turing Tap", R.string.turing_tap));
        locations.add(new Location("Manchester Arena", R.string.manchester_arena));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Locations}. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // fragment_layout layout file.
        final ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(getContext(), "Clickity", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), LocationDetails.class);

                // retrieve current location
                Location location = (Location) listView.getItemAtPosition(position);

                // get the location name and description of the current location
                // and send them along with the intent
                intent.putExtra("LocationName", location.getName());
                intent.putExtra("LocationDescription", location.getDescriptionId());

                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
