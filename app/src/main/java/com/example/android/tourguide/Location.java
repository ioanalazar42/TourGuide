package com.example.android.tourguide;

public class Location {
    private String name;

    // for those locations that also have an associated picture
    private int imageResourceId;

    // we have two constructors because not all locations show a picture
    public Location(String requiredName) {
        name = requiredName;
    }

    public Location(String requiredName, int requiredImageResourceId) {
        this(requiredName);
        imageResourceId = requiredImageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}
