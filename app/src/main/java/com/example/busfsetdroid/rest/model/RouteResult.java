package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class RouteResult {
    String city;
    String route_long_name;
    Integer route_id;
    String route_type;
    String agency_id;
    String route_color;
    String route_url;
    String route_short_name;

    public String getRoute_long_name(){
        return route_long_name;
    }

    public String getRoute_short_name() {
        return route_short_name;
    }

    public Integer getRoute_id(){
        return route_id;
    }
}
