package com.example.busfsetdroid;

import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.busfsetdroid.Utils;

public class UpdateRoutesTask extends AsyncTask
    <String, Void, String> {
		private MainActivity thisAct;
        protected String doInBackground(String... urls) {
            return Utils.readJSONFeed(urls[0]);
        }
        public UpdateRoutesTask(MainActivity thisAct){
        	this.thisAct = thisAct;
        }
        protected void onPostExecute(String result) {
            try {
                JSONObject resultJson = new JSONObject(result);
                JSONArray routeItems = resultJson.getJSONArray("results"); 
                for(int i = 0;i< routeItems.length(); i++){
                	resultJson = routeItems.getJSONObject(i);
                	String key = resultJson.getString("route_long_name");
                	thisAct.spinnerArray.add(key);
                	thisAct.routeMap.put(key,resultJson.getInt("route_id"));
                }
            	Spinner routeSpin = (Spinner) thisAct.findViewById(R.id.route_id);
            	Collections.sort(thisAct.spinnerArray);
            	ArrayAdapter<String> adapter = new ArrayAdapter<String>(thisAct, android.R.layout.simple_spinner_item, thisAct.spinnerArray);
    			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    			routeSpin.setAdapter(adapter);
            } catch (Exception e) {
                Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
            }          
        }
        }
