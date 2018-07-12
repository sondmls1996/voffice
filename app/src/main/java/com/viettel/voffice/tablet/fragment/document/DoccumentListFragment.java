package com.viettel.voffice.tablet.fragment.document;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccumentAdapter;
import com.viettel.voffice.tablet.model.Object.ListDoccumentObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoccumentListFragment extends Fragment {
    ListView lvDoccument;
    ListDoccumentAdapter adapter;
    RelativeLayout rlDocWait;
    LayoutInflater vi;
    LinearLayout ll_menu_left;
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
        vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ll_menu_left = v.findViewById(R.id.ll_menu_left);
        for (int i =0;i<5;i++){
            addTab(i);
        }
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

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.doc_item_wait, null);
                rlDocWait = v.findViewById(R.id.rlDocWait);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v);
                //rlTabSign.setOnClickListener(this);
                break;
            case 1:
                View v1 = vi.inflate(R.layout.doc_item_wait, null);
                rlDocWait = v1.findViewById(R.id.rlDocWait);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v1);
                //rlTabSign.setOnClickListener(this);
                break;
            case 2:
                View v2 = vi.inflate(R.layout.doc_item_wait, null);
                rlDocWait = v2.findViewById(R.id.rlDocWait);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v2);
                //rlTabSign.setOnClickListener(this);
                break;
            case 3:
                View v3 = vi.inflate(R.layout.doc_item_wait, null);
                rlDocWait = v3.findViewById(R.id.rlDocWait);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v3);
                //rlTabSign.setOnClickListener(this);
                break;

        }
    }

}
