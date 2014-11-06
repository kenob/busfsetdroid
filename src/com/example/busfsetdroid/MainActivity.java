package com.example.busfsetdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
	public static HashMap<String, Integer> routeMap = new HashMap<String, Integer>();
	HashMap<String, Integer> stopMap;
	List<String> spinnerArray =  new ArrayList<String>();
	List<String> stops =  new ArrayList<String>();
	ArrayAdapter<String> stopAdapter;
	MainActivity thisAct = this;
	SharedPreferences sharedPrefs;
	private String transitDataURL;
	private String predictionApi;
	private HashMap<String,String> prefsCache = new HashMap<String,String>();
	public HashMap<String, String> agencyMap;
	public Object spinnerArrayA;
	public String finalResult = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//populate prefscache to monitor changes
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		for(String k : sharedPrefs.getAll().keySet()){
			prefsCache.put(k, null);
		}
		setContentView(R.layout.activity_main);
		updateFields();
    	Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
        routeSpin.setOnItemSelectedListener(
                new OnItemSelectedListener(){
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
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

	protected void onResume(){
		super.onResume();
        updateFields();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { 
        case R.id.action_settings:
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            break; 
        }
        return true;
    }
	
	public String update(){
		RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
		String mode = "";
		if(rg1.getCheckedRadioButtonId()!=-1){
		    int id= rg1.getCheckedRadioButtonId();
		    View radioButton = rg1.findViewById(id);
		    int radioId = rg1.indexOfChild(radioButton);
		    RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
		    mode = (String) btn.getText();
		}		
    	AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
		int route_id = routeMap.get(routeSpin.getSelectedItem().toString());
		TimePicker timePicker = (TimePicker) findViewById(R.id.time);
		timePicker.clearFocus();
		String time = timePicker.getCurrentHour().toString() + timePicker.getCurrentMinute().toString() + "00";
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("stop_id", "100");
		data.put("route_id", Integer.toString(route_id));
		data.put("when", time);
		data.put("delay", "5");
		String city = PreferenceManager.getDefaultSharedPreferences(this).getString("city", "buffalo");
		new CallPredictionTask(this, data).execute(predictionApi + city + "/" + mode);
		showResults(mode, finalResult);
		Toast.makeText(getBaseContext(), route_id + " - " + time + " - " + actv.getText().toString() + " - " + mode, 
		 Toast.LENGTH_SHORT).show();
		String result = "";
		return result;
	}
	
	private void populateRouteMap(String urlString){
		new UpdateRoutesTask(this).execute(urlString);
	}

	private void updateFields(){
		PreferenceManager.setDefaultValues(this, R.xml.app_preferences, false);
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		String key = getResources().getString(R.string.transit_data_api_key);
		String base = sharedPrefs.getString(key, "null");
		boolean reset = false;
		if((prefsCache.get(key)!=base)){
			prefsCache.put(key, base);
			reset = true;
		}
		key = getResources().getString(R.string.city_preference_key);
		String cityUrl = sharedPrefs.getString(key, "buffalo");
		if((prefsCache.get(key)!=cityUrl)){
			prefsCache.put(key, cityUrl);
			reset = true;
		}
		new UpdateAgenciesTask(this).execute(base + cityUrl + "/agencies");
		if(reset){
			Spinner routeSpin = (Spinner) findViewById(R.id.route_id);
			routeMap.clear();
			routeSpin.setAdapter(null);
			transitDataURL = base + cityUrl + "/MET/";
			base = sharedPrefs.getString("prediction_api", "null");
			predictionApi = base + cityUrl + "/";
			populateRouteMap(transitDataURL + "routes");
		}

	}
	private void updateStops(String reg, int route_id, boolean query){
		//TODO: move most of these definitions out and make them one-time
		if(!query){
			stops.clear();
			String url = transitDataURL + route_id + "/stops/" + reg.split(" ")[0];
			new UpdateStopsTask(this).execute(url);
		}
	}
	
	private void showResults(String mode, String predictionResult){
		String title = "error";
		String message = "";
		if(mode.equals("Query")){
			message = "The bus will probably be here at " + predictionResult;
			title = "Prediction";
		}
		else if(mode.equals("Report")){
			message = "Thanks a lot, your prediction is extremely useful to us!";
			title = "Update";
		}
		
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
		dlgAlert.setMessage(message);
		dlgAlert.setTitle(title);
		dlgAlert.setPositiveButton("OK", null);
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
		
		dlgAlert.setPositiveButton("Ok",
			    new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) {
			          //dismiss the dialog  
			        }
			    });
	}
}