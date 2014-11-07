package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class AgencyResponse {
    String code;
    @SerializedName("hits")
    String numResults;

    @SerializedName("results")
    List<AgencyResult> results;

    public List<AgencyResult> getResults(){
        return results;
    }
    public HashMap<String,String> getMapForSpinner(){
        HashMap<String,String> ret = new HashMap<String, String>();
        for(AgencyResult r : results){
            String label = r.getAgency_name();
            if(!("".equals(label.trim()))) {
                ret.put(label, r.getAgency_id());
            }
        }
        return ret;
    }
}
