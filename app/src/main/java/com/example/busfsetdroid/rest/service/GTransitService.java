package com.example.busfsetdroid.rest.service;

import com.example.busfsetdroid.rest.model.AgencyResponse;
import com.example.busfsetdroid.rest.model.CityResponse;
import com.example.busfsetdroid.rest.model.GenericResponse;
import com.example.busfsetdroid.rest.model.RouteResponse;
import com.example.busfsetdroid.rest.model.StopLocationResponse;
import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.http.*;

/**
 * Created by kenob on 11/6/14.
 */
public interface GTransitService {
    @GET("/")
    void defaultGet(Callback<JsonElement> callback);

    @GET("/cities")
    void listCities(Callback<CityResponse> callback);

    @GET("/{city}/agencies")
    void listAgencies(@Path("city") String city, Callback<AgencyResponse> callback);

    @GET("/{city}/{agency_id}/routes")
    void listRoutes(@Path("city") String city, @Path("agency_id") String agency_id, Callback<RouteResponse> callback);

//    @GET("/{city}/{agency_id}/{route_id}/trips'")
//    void listTrips(Callback<JsonObject> callback);

    @GET("/{city}/{agency_id}/{route_id}/stops")
    void listStops(@Path("city") String city, @Path("agency_id") String agency_id, @Path("route_id") int route_id, Callback<StopLocationResponse> callback);

    @FormUrlEncoded
    @POST("/login")
    void login(@Field("email") String email, @Field("password") String password,  Callback<GenericResponse> callback);
}
