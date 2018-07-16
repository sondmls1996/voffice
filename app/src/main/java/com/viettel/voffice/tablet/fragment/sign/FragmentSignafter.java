package com.viettel.voffice.tablet.fragment.sign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignafterListObj;
import com.viettel.voffice.tablet.fragment.sign.adapter.SignafterAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignafter extends Fragment {
    RecyclerView lvSign;
    LinearLayout llMenuLeft;
    SignafterAdapter adapter;
    ArrayList<SignafterListObj> arraySign;


    public FragmentSignafter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signafter, container, false);
        init(v);
        return v;
    }
    private void init(View v) {
        setRecycle(v);

        arraySign.add(new SignafterListObj());
        arraySign.add(new SignafterListObj());
        arraySign.add(new SignafterListObj());
        arraySign.add(new SignafterListObj());
        adapter.notifyDataSetChanged();

    }

    private void setRecycle(View v) {
        lvSign = v.findViewById(R.id.rc_view);
        lvSign.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lvSign.setHasFixedSize(true);
        lvSign.setLayoutManager(new LinearLayoutManager(getActivity()));
        arraySign = new ArrayList<>();
        adapter = new SignafterAdapter(getActivity(),arraySign);
        lvSign.setAdapter(adapter);

    }

}
