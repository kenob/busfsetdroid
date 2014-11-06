package com.example.busfsetdroid.rest;

import android.content.Context;
import android.preference.PreferenceManager;

import com.example.busfsetdroid.rest.service.GTransitService;
import com.google.gson.*;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by kenob on 11/6/14.
 */
public class GTransitClient
{
    private static String BASE_URL;
    private GTransitService apiService;
    private Context context;

    public GTransitClient(Context context)    {
        this.BASE_URL = PreferenceManager.getDefaultSharedPreferences(context).getString("transit_data", "/");
        this.context = context;
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new SessionRequestInterceptor())
                .build();

        apiService = restAdapter.create(GTransitService.class);
    }

    public GTransitService getApiService()
    {
        return apiService;
    }

    class SessionRequestInterceptor implements RequestInterceptor
    {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request)
        {
            String auth = PreferenceManager.getDefaultSharedPreferences(context).getString("user_auth", null);
            if(!(auth==null))
                request.addHeader("auth", auth);
        }
    }
}