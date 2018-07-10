package com.viettel.voffice.tablet.fragment.calendal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.RootDocumentFragment;
import com.viettel.voffice.tablet.fragment.RootMoreFragment;


public class CalendalFragment extends Fragment {



    public CalendalFragment() {
        // Required empty public constructor
    }

    public static CalendalFragment newInstance() {

        return new CalendalFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calendal, container, false);
        init(v);
        return v;
    }

    private void init(View v) {


    }


}
