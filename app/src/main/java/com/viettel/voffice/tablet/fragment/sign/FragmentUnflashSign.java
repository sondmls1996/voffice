package com.viettel.voffice.tablet.fragment.sign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.UnFlashsignObj;
import com.viettel.voffice.tablet.fragment.sign.Obj.UnsignListObj;
import com.viettel.voffice.tablet.fragment.sign.adapter.ListUnFlashsignAdapter;
import com.viettel.voffice.tablet.fragment.sign.adapter.ListUnsignAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUnflashSign extends Fragment {

    ListView lvSign;
    LinearLayout llMenuLeft;
    ListUnFlashsignAdapter adapter;
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
        lvSign = v.findViewById(R.id.rc_view);
        arraySign = new ArrayList<>();
        adapter = new ListUnFlashsignAdapter(getActivity(),R.layout.item_sign,arraySign);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        lvSign.setLayoutManager(layoutManager);
        lvSign.setAdapter(adapter);

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

}
