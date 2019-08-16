package com.example.android.tourguide;

public class Location {
    private String name;
    private int descriptionId;

    // for those locations that also have an associated picture
    private int imageResourceId;

    // we have two constructors because not all locations show a picture
    public Location(String requiredName, int requiredDescriptionId) {
        name = requiredName;
        descriptionId = requiredDescriptionId;
    }

    public Location(String requiredName, int requiredDescriptionId, int requiredImageResourceId) {
        imageResourceId = requiredImageResourceId;
        name = requiredName;
        descriptionId = requiredDescriptionId;
    }

    public String getName() {
        return name;
    }

    public int getDescriptionId() {
        return descriptionId;
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
