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
public class FragmentLeft extends Fragment {


    public FragmentLeft() {
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
//                    GeneralClass.showErrorDialog("Button", "You clicked android", FragmentLeft.super.getContext());
                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();

                    Fragment rightFragment = fragmentManager.findFragmentById(R.id.fragmentRight);

                    if(rightFragment == null)
                    {
                        ForumActivityRight forumActivityRight = new ForumActivityRight();
                        forumActivityRight.startActivity(getContext(), "You click Android button.");
                    }
                    else {
                        // Get the TextView object in right Fragment.
                        final TextView rightFragmentTextView = (TextView) rightFragment.getView().findViewById(R.id.fragmentRightTextView);

                        // Set text in right Fragment TextView.
                        rightFragmentTextView.setText("You click Android button.");
                    }
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
