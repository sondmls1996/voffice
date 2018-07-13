package com.viettel.voffice.tablet.fragment.document;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccument;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Doccument extends Fragment implements View.OnClickListener {
    ListView lvDoccument;
    ListDoccument adapter;
    RelativeLayout rlDocWait,rlDocunread,rlDocdone,rlDocsave,rlDocall,rlLibrary;

    ArrayList<ListDoccumentObj> arrayDoccument;
    LayoutInflater vi;
    LinearLayout ll_menu_left;
    public Doccument() {
        // Required empty public constructor
    }
    public static Doccument newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new Doccument();
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
        for (int i =0;i<6;i++){
            addTab(i);
        }
        if(rlDocWait!=null){
            rlDocWait.performClick();
        }

    }

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.doc_item_wait, null);
                rlDocWait = v.findViewById(R.id.rlDocWait);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v);
                rlDocWait.setOnClickListener(this);
                break;
            case 1:
                View v1 = vi.inflate(R.layout.doc_item_unread, null);
                rlDocunread = v1.findViewById(R.id.rlDocunread);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v1);
                rlDocunread.setOnClickListener(this);
                break;
            case 2:
                View v2 = vi.inflate(R.layout.doc_item_done, null);
                rlDocdone = v2.findViewById(R.id.rlDocdone);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v2);
                rlDocdone.setOnClickListener(this);
                break;
            case 3:
                View v3 = vi.inflate(R.layout.doc_item_save, null);
                rlDocsave = v3.findViewById(R.id.rlDocsave);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v3);
                rlDocsave.setOnClickListener(this);
                break;
            case 4:
                View v4 = vi.inflate(R.layout.doc_item_all, null);
                rlDocall = v4.findViewById(R.id.rlDocall);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v4);
                rlDocall.setOnClickListener(this);
                break;
            case 5:
                View v5 = vi.inflate(R.layout.doc_item_library, null);
                rlLibrary = v5.findViewById(R.id.rlDoclibrary);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v5);
                rlLibrary.setOnClickListener(this);
                break;

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.rlDocWait:
                Class wait = FragmentDocWait.class;
                replaceFragment(wait);
                break;
            case R.id.rlDocunread:
                Class unread = FragmentDocUnread.class;
                replaceFragment(unread);
                break;
            case R.id.rlDocdone:
                Class done = FragmentDocDone.class;
                replaceFragment(done);
                break;
            case R.id.rlDocsave:
                Class save = FragmentDocSave.class;
                replaceFragment(save);
                break;
            case R.id.rlDocall:
                Class all = FragmentDocAll.class;
                replaceFragment(all);
                break;
            case R.id.rlDoclibrary:
                Class library = FragmentDocLibrary.class;
                replaceFragment(library);
                break;
        }

    }

    public void replaceFragment(Class fragmentClass){

        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_doccument, fragment).commitAllowingStateLoss();

    }
}
