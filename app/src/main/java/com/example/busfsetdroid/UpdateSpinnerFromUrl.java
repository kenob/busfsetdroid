package com.example.busfsetdroid;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/**
 * Created by kenob on 11/6/14.
 */
public class UpdateSpinnerFromUrl extends UpdateViewFromUrl {
    public UpdateSpinnerFromUrl(Context context, View view, HashMap<String,MyEntry<String,String[]>> fields, HashMap<String, String> data){
        super(context, view,fields,data);
    }
    @Override
    protected void updateView(JSONArray items) throws JSONException{

        HashMap<String,Integer> spinnerMap = new HashMap<String, Integer>();
        ArrayList<String> spinnerArray = new ArrayList<String>();
        String toReplace;
        String replacement;
        String def = " ";
        for(int i = 0;i< items.length(); i++){
            JSONObject resultJson = items.getJSONObject(i);

            MyEntry<String,String[]> values = fields.get("entryValue");
            MyEntry<String,String[]> labels = fields.get("entryText");
            int value = resultJson.optInt(values.getKey(), 0);
            String displayFormat = labels.getKey();
            String[] displayValueKeys = labels.getValue();

            for(int keyPos = 0; keyPos < displayValueKeys.length; keyPos++) {
                toReplace = "%" + keyPos;
                replacement = resultJson.optString(displayValueKeys[keyPos], def);
                displayFormat = displayFormat.replace(toReplace, replacement);
            }
            //update some map for this view here only if actual values were obtained
            if(!("".equals(displayFormat.trim()))) {
                spinnerArray.add(displayFormat);
                spinnerMap.put(displayFormat, value);
            }
        }
        Utils.spinnerMaps.put(view.getId(), spinnerMap);
        Spinner routeSpin = (Spinner) view;
        Collections.sort(spinnerArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        routeSpin.setAdapter(adapter);
    }
}
