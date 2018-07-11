package com.viettel.voffice.tablet.fragment.sign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.adapter.ListSignAdapter;
import com.viettel.voffice.tablet.model.Object.ListSignObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignWait extends Fragment {
    PullToRefreshListView lvSign;
    LinearLayout llMenuLeft;
    ListSignAdapter adapter;
    ArrayList<ListSignObject> arraySign;

    public FragmentSignWait() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_wait, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        lvSign = v.findViewById(R.id.lv_sign);
        arraySign = new ArrayList<>();
        adapter = new ListSignAdapter(getActivity(),R.layout.item_sign,arraySign);

        lvSign.setAdapter(adapter);
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        adapter.notifyDataSetChanged();
    }

}
