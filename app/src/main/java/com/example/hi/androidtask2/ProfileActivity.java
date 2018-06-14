package com.example.hi.androidtask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.apptakk.http_request.HttpRequest;
import com.apptakk.http_request.HttpRequestTask;
import com.apptakk.http_request.HttpResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import cz.msebera.android.httpclient.Header;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import static com.example.hi.androidtask2.HttpRequest.get;


public class ProfileActivity extends AppCompatActivity {

    private final String email_intent = "email";
    private String email;
    TextView textViewLoggedUser;
    TextView textViewPosts;
    TextView textViewSubs;
    TextView textViewReplies;

    AppCompatButton buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        textViewLoggedUser = findViewById(R.id.textViewLoggedUser);
        textViewPosts = findViewById(R.id.textViewPosts);
        textViewSubs = findViewById(R.id.textViewSubs);
        textViewReplies = findViewById(R.id.textViewReplies);


        final GeneralClass generalClass = new GeneralClass();

        if(getIntent()!=null && getIntent().getExtras()!= null) {
            email = getIntent().getStringExtra(email_intent);

            if (email != null)
            {
                textViewLoggedUser.setText("Welcome, " + email);
            }
        }

        buttonShare = findViewById(R.id.btn_share);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareProfileData(email);
            }
        });

        /*HttpRequestModel response = HttpRequest.get("http://beca.diplomado.mescyt.gob.do/Convocatoria/GetCiudades?PaisId=187", null);

        try {
            String test = response.getArray().getJSONObject(0).getString("descripcion");
            generalClass.showErrorDialog("Test",test, this);
        }
        catch (Exception e)
        {
            generalClass.showErrorDialog("Error",e.getMessage(), this);
        }*/

        new HttpRequestTask(
                new HttpRequest("http://beca.diplomado.mescyt.gob.do/Convocatoria/GetCiudades?PaisId=187", HttpRequest.GET, null),
                new HttpRequest.Handler() {
                    @Override
                    public void response(HttpResponse response) {
                        if (response.code == 200) {
                            generalClass.showErrorDialog("Test",response.body, ProfileActivity.this);
                            Log.d(this.getClass().toString(), "Request successful!");
                        } else {
                            generalClass.showErrorDialog("Error",response.body, ProfileActivity.this);
                            Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                        }
                    }
                }).execute();

    }

    private void shareProfileData(String email){
        Intent sendIntent = new Intent();

        String textToSend = "This is my email: " + email;
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
        sendIntent.setType("text/plain");

        startActivity(sendIntent);
    }
}
