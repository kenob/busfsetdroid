package com.example.busfsetdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.busfsetdroid.rest.GTransitClient;
import com.example.busfsetdroid.rest.model.AgencyResponse;
import com.example.busfsetdroid.rest.model.CityResponse;
import com.example.busfsetdroid.rest.model.GenericResponse;
import com.example.busfsetdroid.rest.model.RouteResponse;
import com.example.busfsetdroid.rest.model.StopResponse;
import com.example.busfsetdroid.rest.service.GTransitService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class APITestActivity extends Activity {
    GTransitService service;
    final Context thisContext = this;
    GTransitClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GTransitClient client = new GTransitClient(thisContext);
        service = client.getApiService();
        Button btn = (Button) findViewById(R.id.login_button);
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apitest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_cities_test:
                service.listCities(new Callback<CityResponse>() {
                    @Override
                    public void success(CityResponse res, Response response) {
                        String message = "NOTHING FOR YOU";
                        if(res.getResults().size()>0) {
                            message = res.getResults().get(0).getName();
                        }
                        new AlertDialog.Builder(thisContext).setTitle("TEST SUCCESSFUL!").setMessage(message).create().show();
                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        new AlertDialog.Builder(thisContext).setMessage(
                                "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                        "error: " + retrofitError.getKind().toString()).create().show();
                    }
                });
               break;
            case R.id.action_agencies_test:
                service.listAgencies("buffalo", new Callback<AgencyResponse>() {
                    @Override
                    public void success(AgencyResponse res, Response response) {
                        String message = "NOTHING FOR YOU";
                        if(res.getResults().size()>0) {
                            message = res.getResults().get(0).getAgency_name();
                        }
                        new AlertDialog.Builder(thisContext).setTitle("TEST SUCCESSFUL!").setMessage(message).create().show();
                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        new AlertDialog.Builder(thisContext).setMessage(
                                "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                        "error: " + retrofitError.getKind().toString()).create().show();
                    }
                });
                break;
            case R.id.action_stops_test:
                service.listStops("buffalo", "MET", 1, new Callback<StopResponse>() {
                    @Override
                    public void success(StopResponse res, Response response) {
                        String message = "NOTHING FOR YOU";
                        if(res.getResults().size()>0) {
                            message = res.getResults().get(0).getStop_name();
                        }
                        new AlertDialog.Builder(thisContext).setTitle("TEST SUCCESSFUL!").setMessage(message).create().show();
                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        new AlertDialog.Builder(thisContext).setMessage(
                                "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                        "error: " + retrofitError.getKind().toString()).create().show();
                    }
                });
                break;
            case R.id.action_routes_test:
                service.listRoutes("buffalo","MET", new Callback<RouteResponse>() {
                    @Override
                    public void success(RouteResponse res, Response response) {
                        String message = "NOTHING FOR YOU";
                        if(res.getResults().size()>0) {
                            message = res.getResults().get(0).getRoute_long_name();
                        }
                        new AlertDialog.Builder(thisContext).setTitle("TEST SUCCESSFUL!").setMessage(message).create().show();
                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        new AlertDialog.Builder(thisContext).setMessage(
                                "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                        "error: " + retrofitError.getKind().toString()).create().show();
                    }
                });
                break;
            case R.id.action_login_test:
                service.login("keepitken@gmail.com", "vroooom", new Callback<GenericResponse>() {
                    @Override
                    public void success(GenericResponse res, Response response) {
                        String message = "NOTHING FOR YOU";
                        if(res.getResults().size()>0) {
                            message = res.getResults().get(0).getMessage();
                        }
                        new AlertDialog.Builder(thisContext).setTitle("TEST SUCCESSFUL!").setMessage(message).create().show();
                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        new AlertDialog.Builder(thisContext).setMessage(
                                "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                        "error: " + retrofitError.getKind().toString()).create().show();
                    }
                });
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
