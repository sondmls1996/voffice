package com.viettel.voffice.tablet.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viettel.voffice.tablet.R;


public class RootContactFragment extends Fragment {
    public RootContactFragment() {
        // Required empty public constructor
    }

    public static RootContactFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new RootContactFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_root_contact, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

}
