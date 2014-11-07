package com.example.busfsetdroid.rest.model;

        import org.parceler.Parcel;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class StopResult{
    String city;
    String stop_lat;
    String stop_name;
    String wheelchair_boarding;
    String stop_code;
    String stop_lon;
    String agency_id;
    String stop_id;

    public String getCity() {
        return city;
    }

    public String getStop_lat() {
        return stop_lat;
    }

    public String getStop_name() {
        return stop_name;
    }

    public String getWheelchair_boarding() {
        return wheelchair_boarding;
    }

    public String getStop_code() {
        return stop_code;
    }

    public String getStop_lon() {
        return stop_lon;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public String getStop_id() {
        return stop_id;
    }

    public String getStop_desc() {
        return stop_desc;
    }

    public String getZone_id() {
        return zone_id;
    }

    String stop_desc;
    String zone_id;
}
