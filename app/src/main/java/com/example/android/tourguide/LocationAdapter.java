package com.example.android.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> words) {
        super(context, 0, words);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView image = (ImageView) listItemView.findViewById(R.id.location_pic);
        // Get the resource id from the current (@link Location} object and
        // set the image resource
        image.setImageResource(currentLocation.getImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the location name from the current (@link Location} object and
        // set this text on the name TextView
        locationNameTextView.setText(currentLocation.getName());

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
