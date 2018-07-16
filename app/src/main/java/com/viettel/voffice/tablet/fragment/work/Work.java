package com.viettel.voffice.tablet.fragment.work;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class Work extends Fragment implements View.OnClickListener {

    LinearLayout llMenuLeft;
    RelativeLayout rlListbb,rlTask,rlPersionTask,rlDifficuly,rlAssignment,rlRate,rlSelfRate;
    LayoutInflater vi;
    public Work() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_work, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llMenuLeft = v.findViewById(R.id.ll_menu_left);

        for (int i = 0; i<7;i++){
            addTab(i);
        }
        rlListbb.performClick();
    }

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.work_item_listbb, null);
                rlListbb = v.findViewById(R.id.rlListbb);
                llMenuLeft.addView(v);
                rlListbb.setOnClickListener(this);
                break;
            case 1:
                View v2 = vi.inflate(R.layout.work_item_task, null);
                rlTask = v2.findViewById(R.id.rlTask);
                llMenuLeft.addView(v2);
                rlTask.setOnClickListener(this);
                break;
            case 2:
                View v3 = vi.inflate(R.layout.work_item_persion_task, null);
                rlPersionTask = v3.findViewById(R.id.rlPersionTask);
                llMenuLeft.addView(v3);
                rlPersionTask.setOnClickListener(this);
                break;
            case 3:
                View v4 = vi.inflate(R.layout.work_item_difficulty, null);
                rlDifficuly = v4.findViewById(R.id.rlDifficulty);
                llMenuLeft.addView(v4);
                rlDifficuly.setOnClickListener(this);
                break;
            case 4:
                View v5 = vi.inflate(R.layout.work_item_assignment, null);
                rlAssignment = v5.findViewById(R.id.rlAssignment);
                llMenuLeft.addView(v5);
                rlAssignment.setOnClickListener(this);
                break;
            case 5:
                View v6 = vi.inflate(R.layout.work_item_rate, null);
                rlRate = v6.findViewById(R.id.rlRate);
                llMenuLeft.addView(v6);
                rlRate.setOnClickListener(this);
                break;
            case 6:
                View v7= vi.inflate(R.layout.work_item_self_rate, null);
                rlSelfRate = v7.findViewById(R.id.rlSelfRate);
                llMenuLeft.addView(v7);
                rlSelfRate.setOnClickListener(this);
                break;


        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rlListbb:
                Class list = FragmentListBB.class;
                replaceFragment(list);
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
        fragmentManager.beginTransaction().replace(R.id.content_work
                , fragment).commitAllowingStateLoss();

    }
}
