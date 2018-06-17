package com.example.hi.androidtask2;

import android.os.Build;

import java.util.ArrayList;

public class Devices {

    private String mDeviceName;
    private String mAPI;

    public Devices(String name, String api) {
        mDeviceName = name;
        mAPI = api;
    }

    public String getDeviceName() {
        return mDeviceName;
    }

    public String getAPI() {
        return mAPI;
    }

    public static ArrayList<Devices> createDevicesList(String deviceType) {
        ArrayList<Devices> devices = new ArrayList<Devices>();

        switch (deviceType)
        {
            case "ANDROID":
                devices.add(new Devices(android.os.Build.MODEL + " (THIS IS YOUR DEVICE)", "Android " + Build.VERSION.RELEASE));
                devices.add(new Devices("Google Pixel 2 XL", "Android 9.0 BETA"));
                devices.add(new Devices("Samsung Galaxy S9+", "Android 8.0"));
                devices.add(new Devices("One Plus 6", "Android 9.0 BETA"));
                devices.add(new Devices("Motorola Moto G6 PLUS", "Android 8.1"));
                break;

            case "IOS":
                devices.add(new Devices("Apple Iphone X", "IOS 11.0"));
                devices.add(new Devices("Apple Iphone 8 PLUS", "IOS 11.0"));
                devices.add(new Devices("Apple Iphone 6s PLUS", "IOS 10.1"));
                break;

            case "WINDOWS":
                devices.add(new Devices("Microsoft Lumia 950 XL", "Microsoft Windows 10"));
                devices.add(new Devices("Microsoft Lumia 650", "Microsoft Windows 10"));
                devices.add(new Devices("Microsoft Lumia 640 XL", "Microsoft Windows 10"));
                break;
        }

        return devices;
    }
}
