package com.viettel.voffice.tablet.fragment.document;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.adapter.ListDoccumentAdapter;
import com.viettel.voffice.tablet.adapter.ListSignAdapter;
import com.viettel.voffice.tablet.fragment.RootSignFragment;
import com.viettel.voffice.tablet.model.Object.ListDoccumentObj;
import com.viettel.voffice.tablet.model.Object.ListSignObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoccumentListFragment extends Fragment {
    ListView lvDoccument;
    ListDoccumentAdapter adapter;
    ArrayList<ListDoccumentObj> arrayDoccument;

    public DoccumentListFragment() {
        // Required empty public constructor
    }
    public static DoccumentListFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new DoccumentListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doccument_list, container, false);
        init(v);
        return v;
    }

    private void init(View v) {

        lvDoccument = v.findViewById(R.id.lv_sign);
        arrayDoccument = new ArrayList<>();
        adapter = new ListDoccumentAdapter(getActivity(),R.layout.item_doccument,arrayDoccument);
        lvDoccument.setAdapter(adapter);
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        arrayDoccument.add(new ListDoccumentObj());
        adapter.notifyDataSetChanged();
    }

}
