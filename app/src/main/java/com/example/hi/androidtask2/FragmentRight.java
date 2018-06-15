package com.example.hi.androidtask2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRight extends Fragment {


    public FragmentRight() {
        // Required empty public constructor
    }


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
                    GeneralClass.showErrorDialog("Button", "You clicked android", FragmentRight.super.getContext());
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();
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
