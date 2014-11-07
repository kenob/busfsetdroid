package com.example.busfsetdroid.rest.model;

import org.parceler.Parcel;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class CityResult {
    String slug;
    String name;

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

}
