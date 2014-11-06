package com.example.busfsetdroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class UpdateAgenciesTask extends AsyncTask
<String, Void, String> {
	private MainActivity thisAct;
    protected String doInBackground(String... urls) {
        return Utils.readJSONFeed(urls[0]);
    }
    public UpdateAgenciesTask(MainActivity thisAct){
    	this.thisAct = thisAct;
    }
    
    protected void onPostExecute(String result) {
        try {
        	HashMap<String, String> agencyMap = new HashMap<String, String>();
        	ArrayList<String> array = new ArrayList<String>();
            JSONObject resultJson = new JSONObject(result);
            JSONArray routeItems = resultJson.getJSONArray("results"); 
            for(int i = 0;i< routeItems.length(); i++){
            	resultJson = routeItems.getJSONObject(i);
            	String key = resultJson.optString("agency_name");
            	String value = resultJson.optString("agency_id", "null");
            	array.add(key);
            	agencyMap.put(key, value);
            	thisAct.agencyMap = agencyMap;
            }
        	Spinner routeSpin = (Spinner) thisAct.findViewById(R.id.agency_id);
        	Collections.sort(array);
        	ArrayAdapter<String> adapter = new ArrayAdapter<String>(thisAct, android.R.layout.simple_spinner_item, array);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			routeSpin.setAdapter(adapter); 
	    	} 
        catch (Exception e) {
            Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}

