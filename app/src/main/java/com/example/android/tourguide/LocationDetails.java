package com.example.android.tourguide;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LocationDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_details);

        // add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        // Find the TextView in the location_details.xml layout with the ID version_name
        TextView locationTitle = findViewById(R.id.location_title);
        // Get the resource id from the current (@link Location} object and
        // set the text
        locationTitle.setText(bundle.getString("LocationName"));

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView locationDescription = findViewById(R.id.location_description);
        // Get the location name from the current (@link Location} object and
        // set the text
        locationDescription.setText(bundle.getInt("LocationDescription"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
