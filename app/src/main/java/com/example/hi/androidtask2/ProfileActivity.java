package com.example.hi.androidtask2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;


//import static com.example.hi.androidtask2.HttpRequest.get;


public class ProfileActivity extends AppCompatActivity {

    private final String email_intent = "email";
    private String email;
    private AppCompatButton buttonLogin;
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

        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        email = mSettings.getString(GeneralClass.Values.emailLogged, null);
        textViewLoggedUser.setText("Welcome, " + email);

        /*if(getIntent()!=null && getIntent().getExtras()!= null) {
            email = getIntent().getStringExtra(email_intent);

            if (email != null)
            {
                textViewLoggedUser.setText("Welcome, " + email);
            }
        }*/

        buttonShare = findViewById(R.id.btn_share);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareProfileData(email);
            }
        });

        buttonLogin = findViewById(R.id.btn_forum);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ForumActivityLeft.class);
                startActivity(intent);
            }
        });


        /*new HttpRequestTask(
                new HttpRequest("http://beca.diplomado.mescyt.gob.do/Convocatoria/GetCiudades?PaisId=187", HttpRequest.GET, null),
                new HttpRequest.Handler() {
                    @Override
                    public void response(HttpResponse response) {
                        JSONArray obj = new JSONArray();
                        String strobj = "";
                        try {
                            obj = new JSONArray(response.body);
                            strobj = obj.getJSONObject(0).getString("descripcion");
                        }
                        catch (Exception e)
                        {

                        }

                        if (response.code == 200) {
                            generalClass.showErrorDialog("Test", strobj, ProfileActivity.this);
                            Log.d(this.getClass().toString(), "Request successful!");
                        } else {
                            generalClass.showErrorDialog("Error",response.body, ProfileActivity.this);
                            Log.e(this.getClass().toString(), "Request unsuccessful: " + response);
                        }
                    }
                }).execute();*/
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
