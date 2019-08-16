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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Printworks", R.string.printworks));
        locations.add(new Location("Piccadilly Gardens", R.string.piccadilly_gardens));
        locations.add(new Location("University of Manchester", R.string.uni_manc));
        locations.add(new Location("Old Trafford", R.string.old_trafford));
        locations.add(new Location("Northern Quarter", R.string.northern_quarter));
        locations.add(new Location("Castlefield", R.string.castlefield));
        locations.add(new Location("Manchester Cathedral", R.string.manc_cathedral));
        locations.add(new Location("Chetham's Library", R.string.chetham_lib));
        locations.add(new Location("John Rylands Library", R.string.john_rylands));
        locations.add(new Location("Manchester Art Gallery", R.string.manc_art_gallery));
        locations.add(new Location("Chinatown", R.string.chinatown));
        locations.add(new Location("Manchester Town Hall", R.string.manc_town_hall));
        locations.add(new Location("Heaton Park", R.string.heaton_park));
        locations.add(new Location("Alan Turing Memorial", R.string.alan_turing_memorial));
        locations.add(new Location("Gay Village", R.string.gay_village));

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
