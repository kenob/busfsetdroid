package com.example.busfsetdroid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONArray;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static HashMap<String, Integer> routeMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> stopMap;
	List<String> spinnerArray =  new ArrayList<String>();
	List<String> stops =  new ArrayList<String>();
	ArrayAdapter<String> stopAdapter;
	MainActivity thisAct = this;
	private String transitDataURL = "http://10.0.2.2:5000";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//populate route map here
		String url = transitDataURL + "/transit_data/MET/routes";
		populateRouteMap(url);
		setContentView(R.layout.activity_main);
    	Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
        routeSpin.setOnItemSelectedListener(
                new OnItemSelectedListener(){
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						int route_id = routeMap.get(arg0.getSelectedItem().toString());
				    	AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
				    	actv.addTextChangedListener(new TextWatcher(){
							boolean stopsRetrieved = false;
					        public void afterTextChanged(Editable s) {
					            int i = s.length();
					            if(i>3){
					        		Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
					        		int route_id = routeMap.get(routeSpin.getSelectedItem().toString());					            	
					            	thisAct.updateStops(s.toString(), route_id, stopsRetrieved);
					            	stopsRetrieved = true;				            	
					            }
					            else{
					            	stopsRetrieved = false;
					            }
					        }
					        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
					        public void onTextChanged(CharSequence s, int start, int before, int count){}
					    });
				    	actv.setOnItemClickListener( new OnItemClickListener(){
				    		{
				    	}
							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int arg2, long arg3) {
								// TODO Auto-generated method stub
								thisAct.update();
							}
						});;
					}
                });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public String update(){
		RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
		RadioButton radioButton = (RadioButton) radioButtonGroup.findViewById(radioButtonID);
	    String mode = (String) radioButton.getText();
		
    	AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
		int route_id = routeMap.get(routeSpin.getSelectedItem().toString());
		TimePicker timePicker = (TimePicker) findViewById(R.id.time);
		timePicker.clearFocus();
		String time = timePicker.getCurrentHour().toString() + timePicker.getCurrentMinute().toString() + "00";
		Toast.makeText(getBaseContext(), route_id + " - " + time + " - " + actv.getText().toString() + " - " + mode, 
		 Toast.LENGTH_SHORT).show();
		String result = "";
		return result;
	}
	
	private void populateRouteMap(String urlString){
		new ReadJSONFeedTask().execute(urlString);
	}
	
	private void updateStops(String reg, int route_id, boolean query){
		//TODO: move most of these definitions out and make them one-time
		if(!query){
			stops.clear();
			String url = transitDataURL + "/transit_data/MET/"+ route_id + "/stops/" + reg;
			new ReadJSONFeedTaskS().execute(url);
		}
	}
	
    private class ReadJSONFeedTask extends AsyncTask
    <String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }
 
        protected void onPostExecute(String result) {
            try {
                JSONObject resultJson = new JSONObject(result);
                JSONArray routeItems = resultJson.getJSONArray("results"); 
                for(int i = 0;i< routeItems.length(); i++){
                	resultJson = routeItems.getJSONObject(i);
                	String key = resultJson.getString("route_long_name");
                	spinnerArray.add(key);
                	routeMap.put(key,resultJson.getInt("route_id"));
                }
            	Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
            	Collections.sort(spinnerArray);
            	ArrayAdapter<String> adapter = new ArrayAdapter<String>(thisAct, android.R.layout.simple_spinner_item, spinnerArray);
    			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    			routeSpin.setAdapter(adapter);
            } catch (Exception e) {
                Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
            }          
        }
    }
    private class ReadJSONFeedTaskS extends AsyncTask
    <String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }
 
        protected void onPostExecute(String result) {
            try {
                JSONObject resultJson = new JSONObject(result);
                JSONArray routeItems = resultJson.getJSONArray("results"); 
                for(int i = 0;i< routeItems.length(); i++){
                	resultJson = routeItems.getJSONObject(i);
                	String key = resultJson.getString("stop_name");
                	stops.add(key);
                }
    	    	thisAct.stopAdapter = new ArrayAdapter<String>(thisAct, android.R.layout.simple_list_item_1, stops);
    	    	AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1); 
    	    	actv.setAdapter(stopAdapter);            	
    	    	} 
            catch (Exception e) {
                Log.d("ReadJSONFeedTask", e.getLocalizedMessage());
            }          
        }
    }
	
    public String readJSONFeed(String URL) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
            } else {
                Log.d("JSON", "Failed to download file");
            }
        } catch (Exception e) {
            Log.d("readJSONFeed", e.getLocalizedMessage());
        }        
        return stringBuilder.toString();
    }
}
