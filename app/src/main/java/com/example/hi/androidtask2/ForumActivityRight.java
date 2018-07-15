package com.example.hi.androidtask2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
        fillDevices(intent.getStringExtra(INTENT_DEVICE_TYPE), null);

    }

    public void startActivity(Context ctx, FragmentTransaction ft, String message, View view)
    {
        if (GeneralClass.isPortrait(ctx))
        {
            Intent intent  = new Intent(ctx, ForumActivityRight.class);
            intent.putExtra(INTENT_DEVICE_TYPE, message);
            ctx.startActivity(intent);
        }
        else
        {
            //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.replace(R.id.devices_cointainer, new FragmentRight());
            //ft.commit();
            fillDevices(message, view);
        }

    }

    public void fillDevices(String deviceType, View view)
    {
        if (deviceType.isEmpty())
        {
            Intent intent = getIntent();
            deviceType = intent.getStringExtra(INTENT_DEVICE_TYPE);
        }

        RecyclerView rvDevices = null;
        TextView deviceTypeTextView = null;

        if (view == null)
        {
            rvDevices = (RecyclerView) findViewById(R.id.rvDevices);
            deviceTypeTextView = (TextView) findViewById(R.id.device_type);

        }
        else
        {
            rvDevices = (RecyclerView) view.findViewById(R.id.rvDevices);
            deviceTypeTextView = (TextView) view.findViewById(R.id.device_type);
        }

        deviceTypeTextView.setText(deviceType + " DEVICES");

        devices = Devices.createDevicesList(deviceType);
        DevicesAdapter adapter = new DevicesAdapter(devices);
        rvDevices.setAdapter(adapter);
        rvDevices.setLayoutManager(new LinearLayoutManager(this));
    }
}
