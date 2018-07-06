package com.viettel.voffice.tablet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viettel.voffice.tablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootSignFragment extends Fragment {


    public RootSignFragment() {
        // Required empty public constructor
    }

    public static RootSignFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new RootSignFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_root_sign, container, false);
    }

}
