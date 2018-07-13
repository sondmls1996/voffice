package com.viettel.voffice.tablet.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.calendal.CalendarWeek;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootCalendalFragment extends Fragment implements View.OnClickListener {
    LayoutInflater vi;
    LinearLayout ll_menu_left;
    RelativeLayout rlLichBTGD,rlLichtuan,rlLichBGD,rlLichctBGD,rlLichctBTDG;
    public RootCalendalFragment() {
        // Required empty public constructor
    }
    public static RootCalendalFragment newInstance() {

        return new RootCalendalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_root_calendal, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ll_menu_left = v.findViewById(R.id.ll_menu_left);
        for (int i =0;i<5;i++){
            addTab(i);
        }
        if(rlLichtuan!=null){
            rlLichtuan.performClick();
        }
    }

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.calendal_item_lichtuan, null);
                rlLichtuan = v.findViewById(R.id.rlLichtuan);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v);
                rlLichtuan.setOnClickListener(this);

                break;
            case 1:
//                View v1 = vi.inflate(R.layout.calendal_item_lichbtgd, null);
//                rlLichBTGD = v1.findViewById(R.id.rlCalBTGD);
////                tvTabSign = v.findViewById(R.id.tv_title_sign);
////                imgTabSign = v.findViewById(R.id.imv_sign);
//                ll_menu_left.addView(v1);
//                rlLichBTGD.setOnClickListener(this);

                break;
            case 2:
                View v2 = vi.inflate(R.layout.calendar_item_lichctbgd, null);
                rlLichctBGD = v2.findViewById(R.id.rlLichctBGD);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v2);
                rlLichctBGD.setOnClickListener(this);

                break;
            case 3:

                View v3 = vi.inflate(R.layout.calendal_item_lichbtgd, null);
                rlLichBTGD = v3.findViewById(R.id.rlLichtBTGD);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v3);
                rlLichBTGD.setOnClickListener(this);
                break;
            case 4:
                View v4 = vi.inflate(R.layout.calendar_item_lichctbtgd, null);
                rlLichctBTDG = v4.findViewById(R.id.rlLichctBTGD);
//                tvTabSign = v.findViewById(R.id.tv_title_sign);
//                imgTabSign = v.findViewById(R.id.imv_sign);
                ll_menu_left.addView(v4);
                rlLichctBTDG.setOnClickListener(this);

                break;



        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rlLichtuan:
                Class week = CalendarWeek.class;
                replaceFragment(week);
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
        fragmentManager.beginTransaction().replace(R.id.content_right
                , fragment).commitAllowingStateLoss();

    }
}
