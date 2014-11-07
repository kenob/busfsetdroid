package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class RouteResponse {
    @SerializedName("hits")
    String numResults;

    @SerializedName("results")
    List<RouteResult> results;

    public List<RouteResult> getResults(){
        return results;
    }

    public HashMap<String,Integer> getMapForSpinner(){
        HashMap<String,Integer> ret = new HashMap<String, Integer>();
        for(RouteResult r : results){
            String label = r.getRoute_short_name()+ " " + r.getRoute_long_name();
            if(!("".equals(label.trim()))) {
                ret.put(label, r.getRoute_id());
            }
        }
        return ret;
    }
}
