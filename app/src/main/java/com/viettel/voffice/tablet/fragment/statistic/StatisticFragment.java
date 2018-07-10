package com.viettel.voffice.tablet.fragment.statistic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.RootStatisticFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment {

    TextView tvPersion,tvDoc;
    public StatisticFragment() {
        // Required empty public constructor
    }

    public static StatisticFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new StatisticFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_statistic, container, false);
        init(v);
        tvPersion.performClick();
        return v;
    }

    private void init(View v) {
        tvPersion = v.findViewById(R.id.txt_persion);
        tvDoc = v.findViewById(R.id.txt_doc);
        tvPersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSelectAll();
                tvPersion.setTextColor(getResources().getColor(R.color.WHITE_COLOR));
                tvPersion.setBackground(getResources().getDrawable(R.drawable.tab_stroke_select_left));
            }
        });

        tvDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSelectAll();
                tvDoc.setTextColor(getResources().getColor(R.color.WHITE_COLOR));
                tvDoc.setBackground(getResources().getDrawable(R.drawable.tab_stroke_select_right));
            }
        });


    }
    public void unSelectAll(){
        tvPersion.setBackground(getResources().getDrawable(R.drawable.tab_stroke_notselect_left));
        tvPersion.setTextColor(getResources().getColor(R.color.toolbar_title_color));
        tvDoc.setBackground(getResources().getDrawable(R.drawable.tab_stroke_not_select_right));
        tvDoc.setTextColor(getResources().getColor(R.color.toolbar_title_color));
    }
}
