package com.viettel.voffice.tablet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.model.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootWorkFragment extends Fragment {

    RelativeLayout rlLeft,rlRight;
    public RootWorkFragment() {
        // Required empty public constructor
    }

    public static RootWorkFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new RootWorkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_root_work, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        rlLeft = v.findViewById(R.id.rl_left);
        rlRight = v.findViewById(R.id.rl_right);
        Utils.setWidthLeft(rlLeft);
    }

}
