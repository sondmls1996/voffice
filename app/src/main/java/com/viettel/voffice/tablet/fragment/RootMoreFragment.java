package com.viettel.voffice.tablet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.more.MoreFragment;
import com.viettel.voffice.tablet.fragment.sign.SignFragment;
import com.viettel.voffice.tablet.model.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootMoreFragment extends Fragment {
        RelativeLayout rlLeft,rlRight;

    public RootMoreFragment() {
        // Required empty public constructor
    }

    public static RootMoreFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new RootMoreFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_root_more, container, false);
        init(v);
        Fragment more = MoreFragment.newIntance();
        changeTabLeft(more);
        return v;
    }

    private void init(View v) {
        rlLeft = v.findViewById(R.id.rl_left);
        rlRight = v.findViewById(R.id.rl_right);
        Utils.setWidthLeft(rlLeft);
    }

    public void changeTabLeft(Fragment fragment) {

        FragmentManager frManager = getActivity().getSupportFragmentManager();

        FragmentTransaction replace = frManager.beginTransaction().replace(
                R.id.content_left, fragment);

        replace.commit();

    }
}
