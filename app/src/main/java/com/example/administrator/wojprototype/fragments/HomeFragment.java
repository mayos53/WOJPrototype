package com.example.administrator.wojprototype.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wojprototype.App;
import com.example.administrator.wojprototype.MainActivity;
import com.example.administrator.wojprototype.R;
import com.example.administrator.wojprototype.model.Spam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossef on 4/27/15.
 */
public class HomeFragment extends Fragment {

    App app;
    TextView number;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (App)getActivity().getApplication();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        number = (TextView)view.findViewById(R.id.number);

        View messages = view.findViewById(R.id.messages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onNavigationDrawerItemSelected(1);
            }
        });

        View law_suits = view.findViewById(R.id.law_suits);
        law_suits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onNavigationDrawerItemSelected(2);
            }
        });

        View sum = view.findViewById(R.id.sum);
        law_suits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onNavigationDrawerItemSelected(2);
            }
        });

        return view;


    }




    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                1);
    }


}
