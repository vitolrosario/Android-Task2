package com.example.hi.androidtask2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ForumActivityRight extends AppCompatActivity {

    private final static String INTENT_DEVICES = "INTENT_DEVICES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_right);
    }

    public void startActivity(Context ctx, String message)
    {
        Intent intent  = new Intent(ctx, ForumActivityRight.class);
        intent.putExtra(INTENT_DEVICES, message);
        ctx.startActivity(intent);
    }
}
