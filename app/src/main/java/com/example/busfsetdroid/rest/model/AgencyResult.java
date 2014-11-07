package com.example.busfsetdroid.rest.model;

import org.parceler.Parcel;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class AgencyResult {
    String agency_phone;
    String  city;
    String  agency_url;
    String  agency_name;
    String  agency_timezone;
    String  agency_lang;

    public String getAgency_id() {
        return agency_id;
    }

    String agency_id;

    public String getAgency_phone() {
        return agency_phone;
    }

    public String getCity() {
        return city;
    }

    public String getAgency_url() {
        return agency_url;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public String getAgency_timezone() {
        return agency_timezone;
    }

    public String getAgency_lang() {
        return agency_lang;
    }
}
