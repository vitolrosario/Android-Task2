package com.example.hi.androidtask2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLeft extends Fragment {


    public FragmentLeft() {
        // Required empty public constructor
    }

    private static FragmentTransaction fragmentTransaction = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_left, container, false);

        final FragmentActivity fragmentBelongActivity = getActivity();

        if (retView != null)
        {
            LinearLayout androidButton = (LinearLayout) retView.findViewById(R.id.btn_android);
            androidButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ForumActivityRight forumActivityRight = new ForumActivityRight();
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    forumActivityRight.startActivity(getContext(), fragmentTransaction, "ANDROID");
                }
            });

            LinearLayout appleButton = (LinearLayout) retView.findViewById(R.id.btn_apple);
            appleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ForumActivityRight forumActivityRight = new ForumActivityRight();
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    forumActivityRight.startActivity(getContext(),fragmentTransaction,  "IOS");
                }
            });

            LinearLayout windowsButton = (LinearLayout) retView.findViewById(R.id.btn_windows);
            windowsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ForumActivityRight forumActivityRight = new ForumActivityRight();
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    forumActivityRight.startActivity(getContext(),fragmentTransaction,  "WINDOWS");
                }
            });

        }
        return retView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

}
