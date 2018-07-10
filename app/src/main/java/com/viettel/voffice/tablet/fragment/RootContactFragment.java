package com.viettel.voffice.tablet.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.contact.ContactFragment;
import com.viettel.voffice.tablet.model.Utils;


public class RootContactFragment extends Fragment {
    RelativeLayout rlLeft,rlRight;

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
        View v = inflater.inflate(R.layout.fragment_root_contact, container, false);
        init(v);
        Fragment contact = ContactFragment.newIntance();
        changeTabLeft(contact);
        return v;
    }

    private void init(View v) {
        rlLeft = v.findViewById(R.id.rl_left);
        rlRight = v.findViewById(R.id.rl_left);
        Utils.setWidthLeft(rlLeft);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void changeTabLeft(Fragment fragment) {

        FragmentManager frManager = getActivity().getSupportFragmentManager();

        FragmentTransaction replace = frManager.beginTransaction().replace(
                R.id.content_left, fragment);

        replace.commit();

    }
}
