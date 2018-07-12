package com.viettel.voffice.tablet.fragment.sign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.FlashSignListObj;
import com.viettel.voffice.tablet.fragment.sign.Obj.FlashSignedListObj;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignedListObj;
import com.viettel.voffice.tablet.fragment.sign.adapter.ListFlashSignAdapter;
import com.viettel.voffice.tablet.fragment.sign.adapter.ListFlashSignedAdapter;
import com.viettel.voffice.tablet.fragment.sign.adapter.ListSignedAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFlashSigned extends Fragment {
    ListView lvSign;
    LinearLayout llMenuLeft;
    ListFlashSignedAdapter adapter;
    ArrayList<FlashSignedListObj> arraySign;

    public FragmentFlashSigned() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_flash_signed, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        lvSign = v.findViewById(R.id.rc_view);
        arraySign = new ArrayList<>();
        adapter = new ListFlashSignedAdapter(getActivity(),R.layout.item_sign,arraySign);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        lvSign.setLayoutManager(layoutManager);
        lvSign.setAdapter(adapter);

        arraySign.add(new FlashSignedListObj());
        arraySign.add(new FlashSignedListObj());
        arraySign.add(new FlashSignedListObj());
        arraySign.add(new FlashSignedListObj());
        arraySign.add(new FlashSignedListObj());
        arraySign.add(new FlashSignedListObj());
        adapter.notifyDataSetChanged();
    }

}
