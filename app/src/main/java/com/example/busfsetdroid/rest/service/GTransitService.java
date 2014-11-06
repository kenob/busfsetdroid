package com.example.busfsetdroid.rest.service;

import com.example.busfsetdroid.rest.model.GenericResponse;

import retrofit.Callback;
import retrofit.http.*;

/**
 * Created by kenob on 11/6/14.
 */
public interface GTransitService {
    @GET("/routes")
    void listRoutes();

    @GET("/")
    void defaultGet(Callback<GenericResponse> callback);

    @FormUrlEncoded
    @POST("/login")
    void login(@Field("email") String email, @Field("password") String password,  Callback<String> callback);
}
