package com.example.busfsetdroid;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.busfsetdroid.Utils;

public class UpdateStopsTask extends AsyncTask
<String, Void, String> {
	private MainActivity thisAct;
    protected String doInBackground(String... urls) {
        return Utils.readJSONFeed(urls[0]);
    }
    public UpdateStopsTask(MainActivity thisAct){
    	this.thisAct = thisAct;
    }
    
    protected void onPostExecute(String result) {
        try {
            JSONObject resultJson = new JSONObject(result);
            JSONArray routeItems = resultJson.getJSONArray("results"); 
            for(int i = 0;i< routeItems.length(); i++){
            	resultJson = routeItems.getJSONObject(i);
            	String key = resultJson.getString("stop_name");
            	thisAct.stops.add(key);
            }
	    	thisAct.stopAdapter = new ArrayAdapter<String>(thisAct, android.R.layout.simple_list_item_1, thisAct.stops);
	    	AutoCompleteTextView actv = (AutoCompleteTextView) thisAct.findViewById(R.id.autoCompleteTextView1); 
	    	actv.setAdapter(thisAct.stopAdapter);            	
	    	} 
        catch (Exception e) {
            Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}


