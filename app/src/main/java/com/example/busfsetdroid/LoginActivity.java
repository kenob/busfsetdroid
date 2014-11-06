package com.example.busfsetdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.busfsetdroid.rest.GTransitClient;
import com.example.busfsetdroid.rest.model.GenericResponse;
import com.example.busfsetdroid.rest.service.GTransitService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Context thisContext = this;
        final GTransitClient client = new GTransitClient(thisContext);
        Button btn = (Button) findViewById(R.id.login_button);
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                GTransitService service = client.getApiService();
                TextView v = (TextView) findViewById(R.id.login_password);
                String password = v.getText().toString();
                v = (TextView) findViewById(R.id.login_email);
                String email = v.getText().toString();
                service.defaultGet(new Callback<GenericResponse>() {
                        @Override
                        public void success(GenericResponse res, Response response) {
                            new AlertDialog.Builder(thisContext).setMessage("Success! + \n" +
                                                    "number of results: " + res.getNumResults()).create().show();
                        }
                        @Override
                        public void failure(RetrofitError retrofitError) {
                            new AlertDialog.Builder(thisContext).setMessage(
                                    "Request to " + retrofitError.getUrl() + " unsuccessful! \n" +
                                            "error: " + retrofitError.getKind().toString()).create().show();
                        }
                    });
                }
        });
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
