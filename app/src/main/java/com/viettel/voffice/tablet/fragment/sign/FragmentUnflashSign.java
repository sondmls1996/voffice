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
import com.viettel.voffice.tablet.fragment.sign.Obj.UnFlashsignObj;
import com.viettel.voffice.tablet.fragment.sign.adapter.UnFlashsignAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUnflashSign extends Fragment {

    RecyclerView lvSign;
    LinearLayout llMenuLeft;
    UnFlashsignAdapter adapter;
    ArrayList<UnFlashsignObj> arraySign;
    public FragmentUnflashSign() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_unflash_sign, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
       setRecycle(v);
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        arraySign.add(new UnFlashsignObj());
        adapter.notifyDataSetChanged();

    }
    private void setRecycle(View v) {
        lvSign = v.findViewById(R.id.rc_view);
        lvSign.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lvSign.setHasFixedSize(true);
        lvSign.setLayoutManager(new LinearLayoutManager(getActivity()));
        arraySign = new ArrayList<>();
        adapter = new UnFlashsignAdapter(getActivity(),arraySign);
        lvSign.setAdapter(adapter);

    }
}
