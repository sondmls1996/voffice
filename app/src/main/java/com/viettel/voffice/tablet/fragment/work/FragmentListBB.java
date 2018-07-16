package com.viettel.voffice.tablet.fragment.work;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.adapter.SignAllAdapter;
import com.viettel.voffice.tablet.fragment.work.adapter.ListBBAdapter;
import com.viettel.voffice.tablet.fragment.work.obj.ListBBObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListBB extends Fragment {
    RecyclerView recycle;
    ListBBAdapter adapter;
    ArrayList<ListBBObj> arr;

    public FragmentListBB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_bb, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        setRecycle(v);
        arr.add(new ListBBObj());
        arr.add(new ListBBObj());
        arr.add(new ListBBObj());
        arr.add(new ListBBObj());
        arr.add(new ListBBObj());
        adapter.notifyDataSetChanged();

    }
    private void setRecycle(View v) {
        recycle = v.findViewById(R.id.rc_view);
        recycle.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        arr = new ArrayList<>();
        adapter = new ListBBAdapter(getActivity(),arr);
        recycle.setAdapter(adapter);

    }
}
