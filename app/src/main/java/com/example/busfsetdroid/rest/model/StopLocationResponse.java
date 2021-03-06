package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class StopLocationResponse {
    @SerializedName("hits")
    String numResults;

    @SerializedName("results")
    List<StopLocationResult> results;

    public List<StopLocationResult> getResults() {
        return results;
    }
    public HashMap<String,String> getMapForSpinner(){
        HashMap<String,String> ret = new HashMap<String, String>();
        for(StopLocationResult r : results){
            String label = r.getStop_name();
            if(!("".equals(label.trim()))) {
                ret.put(label, r.getStop_id());
            }
        }
        return ret;
    }
}