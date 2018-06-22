package com.example.hi.androidtask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

public class ForumActivityLeft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_left);

//        EmptyRecyclerView recyclerView = (EmptyRecyclerView) findViewById(R.id.rvDevices);
//        recyclerView.setEmptyView(findViewById(R.id.empty_view));

        /*RecyclerViewEmptySupport list = (RecyclerViewEmptySupport) findViewById(R.id.rvDevices);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setEmptyView(findViewById(R.id.empty_view));*/

    }
}
