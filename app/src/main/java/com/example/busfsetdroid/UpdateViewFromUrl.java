package com.example.busfsetdroid;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.busfsetdroid.Utils;

public abstract class UpdateViewFromUrl extends AsyncTask
    <String, Void, String> {
        protected HashMap<String,MyEntry<String,String[]>> fields;
        protected HashMap<String, String> data;
        protected View view;
        protected Context context;
        protected String doInBackground(String... urls){
            if(data.isEmpty()) {
                return Utils.readJSONFeed(urls[0]);
            }
            else{
                try {
                    return Utils.readJSONFeedPOST(urls[0], data);
                }
                catch (UnsupportedEncodingException u){
                    return null;
                }
            }
        }
        public UpdateViewFromUrl(Context context, View view, HashMap<String,MyEntry<String,String[]>> fields, HashMap<String, String> data){
            this.data = data;
            this.fields = fields;
            this.view = view;
            this.context = context;
        }
        protected void onPostExecute(String result) {
            if(!(result==null)) {
                try {
                    JSONObject resultJson = new JSONObject(result);
                    JSONArray routeItems = resultJson.getJSONArray("results");
                    updateView(routeItems);
                } catch (Exception e) {
                    Log.d("UpdateViewFromUrl", e.getLocalizedMessage());
                }
            }
        }
        protected abstract void updateView(JSONArray j) throws JSONException;
        }
