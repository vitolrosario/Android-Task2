package com.example.hi.androidtask2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.ViewHolder>
{

    private  List<Devices> mDevices;

    public DevicesAdapter(List<Devices> devices) {
        mDevices = devices;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView deviceTextView;
        public TextView apiTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            deviceTextView = (TextView) itemView.findViewById(R.id.device_name);
            apiTextView = (TextView) itemView.findViewById(R.id.api_name);
        }
    }

    @Override
    public DevicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View deviceView = inflater.inflate(R.layout.item_device, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(deviceView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DevicesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Devices device = mDevices.get(position);

        // Set item views based on your views and data model
        TextView deviceTextView = viewHolder.deviceTextView;
        deviceTextView.setText(device.getDeviceName());
        TextView apiTextViw = viewHolder.apiTextView;
        apiTextViw.setText(device.getAPI());
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

}