package com.example.hi.androidtask2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class ForumActivityRight extends AppCompatActivity {

    private final static String INTENT_DEVICE_TYPE = "INTENT_DEVICE_TYPE";
    ArrayList<Devices> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_right);

        Intent intent = getIntent();
        String deviceType = intent.getStringExtra(INTENT_DEVICE_TYPE);

        RecyclerView rvDevices = (RecyclerView) findViewById(R.id.rvDevices);
        TextView deviceTypeTextView = (TextView) findViewById(R.id.device_type);
        deviceTypeTextView.setText(deviceType + " DEVICES");

        devices = Devices.createDevicesList(deviceType);
        DevicesAdapter adapter = new DevicesAdapter(devices);
        rvDevices.setAdapter(adapter);
        rvDevices.setLayoutManager(new LinearLayoutManager(this));

    }

    public void startActivity(Context ctx, String message)
    {
        Intent intent  = new Intent(ctx, ForumActivityRight.class);
        intent.putExtra(INTENT_DEVICE_TYPE, message);
        ctx.startActivity(intent);
    }
}
