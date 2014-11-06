package com.example.busfsetdroid;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.example.busfsetdroid.Utils;

public class CallPredictionTask extends AsyncTask
<String, Void, String> {
	private MainActivity thisAct;
	HashMap<String, String> data;
	ArrayList<String[]> res = new ArrayList<String[]>();
    protected String doInBackground(String... urls) {
        try {
			return Utils.readJSONFeedPOST(urls[0], data);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
    }
    public CallPredictionTask(MainActivity thisAct, HashMap<String, String> data){
    	this.thisAct = thisAct;
        this.data = data;
    }
    
    protected void onPostExecute(String result) {
        try {
            JSONObject resultJson = new JSONObject(result);
            String items = resultJson.getString("message");
            thisAct.finalResult = items;
        }
        catch (Exception e) {
            Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}


