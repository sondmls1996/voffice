package com.viettel.voffice.tablet.fragment.document;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccument;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDocWait extends Fragment {
    ListView lvSign;
    LinearLayout llMenuLeft;
    ListDoccument adapter;
    ArrayList<ListDoccumentObj> arraySign;

    public FragmentDocWait() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doc_wait, container, false);
        init(v);
        return v;
    }
    private void init(View v) {
        lvSign = v.findViewById(R.id.rc_view);
        arraySign = new ArrayList<>();
        adapter = new ListDoccument(getActivity(),R.layout.item_doccument,arraySign);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        lvSign.setLayoutManager(layoutManager);
        lvSign.setAdapter(adapter);

        arraySign.add(new ListDoccumentObj());
        arraySign.add(new ListDoccumentObj());
        arraySign.add(new ListDoccumentObj());
        arraySign.add(new ListDoccumentObj());
        adapter.notifyDataSetChanged();
    }
}
