package com.example.hi.androidtask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

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

//        String result = HttpRequest.get("https://api.twitter.com/1/", null, new JsonHttpResponseHandler());
//
//        new GeneralClass().showErrorDialog("Test", result, this);
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
