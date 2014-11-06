package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class GenericResponse {
    @SerializedName("hits")
    private Integer numResults;

    @SerializedName("status")
    private String statusCode;

    @SerializedName("results")
    private ArrayList<ResultResponse> results;

    public int getNumResults(){
        return numResults;
    }
    public String getStatus(){
        return statusCode;
    }
    public ArrayList<ResultResponse> getResults(){
        return results;
    }
}
