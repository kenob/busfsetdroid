package com.example.busfsetdroid.rest.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class GenericResponse {
    String code;
    @SerializedName("hits")
    String numResults;

    @SerializedName("results")
    List<ResultResponse> results;

    public List<ResultResponse> getResults(){
        return results;
    }
}
