package com.example.busfsetdroid;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.example.busfsetdroid.Utils;

public class UpdateCitiesTask extends AsyncTask
<String, Void, String> {
	private PreferenceFragment thisAct;
	ArrayList<String[]> res = new ArrayList<String[]>();
    protected String doInBackground(String... urls) {
        return Utils.readJSONFeed(urls[0]);
    }
    public UpdateCitiesTask(PreferenceFragment thisAct){
    	this.thisAct = thisAct;
    }
    
    protected void onPostExecute(String result) {
        try {
            JSONObject resultJson = new JSONObject(result);
            JSONArray items = resultJson.getJSONArray("results");
            int len = items.length();
            String[] entries = new String[len];
            String[] entryValues = new String[len];
            for(int i = 0;i< items.length(); i++){
            	resultJson = items.getJSONObject(i);
            	entries[i] = resultJson.getString("name");
            	entryValues[i] = resultJson.getString("slug");
            }
            res.add(entries);
            res.add(entryValues);
            ListPreference customListPref = (ListPreference)thisAct.findPreference(thisAct.getResources().getString(R.string.city_preference_key));
            // Get the Preference Category which we want to add the ListPreference to
            customListPref.setEntries(entries);
	        customListPref.setEntryValues(entryValues); 
        }
        catch (Exception e) {
            Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}


