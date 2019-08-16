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
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Football Museum", R.string.football_mueseum, R.drawable.football));
        locations.add(new Location("Manchester Museum", R.string.manc_museum, R.drawable.museum));
        locations.add(new Location("Police Museum", R.string.police_museum, R.drawable.police));
        locations.add(new Location("Salford Museum", R.string.salford_museum, R.drawable.art));
        locations.add(new Location("Transport Museum", R.string.transport_museum, R.drawable.transport));

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
