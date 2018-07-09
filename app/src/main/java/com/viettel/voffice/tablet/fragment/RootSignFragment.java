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
import com.viettel.voffice.tablet.fragment.sign.SignFragment;
import com.viettel.voffice.tablet.model.Constant;
import com.viettel.voffice.tablet.model.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootSignFragment extends Fragment {
    RelativeLayout rlLeft,rlRight;
    View v;
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
        v = inflater.inflate(R.layout.fragment_root_sign, container, false);

        init(v);
        Fragment listSign = SignFragment.newIntance();
        changeTabLeft(listSign);
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
    public void changeTabRight(Fragment fragment) {

        FragmentManager frManager = getActivity().getSupportFragmentManager();

        FragmentTransaction replace = frManager.beginTransaction().replace(
                R.id.content_right, fragment);

        replace.commit();

    }
}
