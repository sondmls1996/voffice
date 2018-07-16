package com.viettel.voffice.tablet.fragment.document;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viettel.voffice.tablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDocLibrary extends Fragment {


    public FragmentDocLibrary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doc_library, container, false);
        return v;
    }

}
