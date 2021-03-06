package com.example.administrator.wojprototype.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.wojprototype.MainActivity;

/**
 * Created by Yossef on 4/27/15.
 */
public class LawSuitsFragment extends Fragment {

    FragmentTabHost mTabHost;

    @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            mTabHost = new FragmentTabHost(getActivity());
            mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.content);

        mTabHost.addTab(mTabHost.newTabSpec("messagesDismiss").setIndicator("בתהליך"),
                MsgFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("messageSuspect").setIndicator("הושלמו"),
                    MsgFragment.class, null);


            return mTabHost;
        }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                3);
    }
}
