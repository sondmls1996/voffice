package com.viettel.voffice.tablet.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.RootContactFragment;
import com.viettel.voffice.tablet.fragment.RootDocumentFragment;
import com.viettel.voffice.tablet.fragment.RootMoreFragment;
import com.viettel.voffice.tablet.fragment.RootSignFragment;
import com.viettel.voffice.tablet.model.Constant;


public class Voffice extends AppCompatActivity implements View.OnClickListener {
    LinearLayout llMenu;
    RelativeLayout rlMenuRight;
    RelativeLayout rlTabSign,rlTabDoccument,rlTabMore,rlTabContact,rlTabCalendal,rlTabChart,rlTabTransImage;
    FrameLayout frameContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voffice);
        Constant.WIDTH_LEFT_TITLE = getDisplayWidth();
        init();

    }

    private void init() {
        rlMenuRight = findViewById(R.id.rightMenu);
        llMenu = findViewById(R.id.ll_menu_right);
        frameContent = findViewById(R.id.frameContent);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0;i<10; i ++){
         addTab(i,vi);
        }
        View v = vi.inflate(R.layout.layout_tab_more, null);
        rlTabMore = v.findViewById(R.id.rlTabMore);
        llMenu.addView(v);
        rlTabMore.setOnClickListener(this);
        if(rlTabSign!=null){
            rlTabSign.performClick();
        }

    }

    public Float getDisplayWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;
        return width;
    }
    private void addTab(int i,LayoutInflater vi) {

        switch (i){
            case 1:

                View v = vi.inflate(R.layout.layout_tab_sign, null);
                rlTabSign = v.findViewById(R.id.rlTabSign);
                llMenu.addView(v);
                rlTabSign.setOnClickListener(this);


                break;
            case 2:
                View v1 = vi.inflate(R.layout.layout_tab_document, null);
                rlTabDoccument = v1.findViewById(R.id.rlTabDocument);
                llMenu.addView(v1);
                rlTabDoccument.setOnClickListener(this);
                break;
            case 3:
                View v2 = vi.inflate(R.layout.layout_tab_calendar, null);
                rlTabCalendal = v2.findViewById(R.id.rlTabCalendar);
                llMenu.addView(v2);
                v2.setOnClickListener(this);
                break;
            case 4:
                View v3 = vi.inflate(R.layout.layout_tab_chart, null);
                rlTabChart = v3.findViewById(R.id.rlTabChart);
                llMenu.addView(v3);
                v3.setOnClickListener(this);
                break;
            case 5:
                View v4 = vi.inflate(R.layout.layout_tab_contact, null);
                rlTabContact = v4.findViewById(R.id.rlTabContact);
                llMenu.addView(v4);
                rlTabContact.setOnClickListener(this);
                break;
            case 6:
                View v5 = vi.inflate(R.layout.layout_tab_reiview, null);

                llMenu.addView(v5);
                v5.setOnClickListener(this);
                break;

            case 7:
                View v6 = vi.inflate(R.layout.layout_tab_search, null);
                llMenu.addView(v6);
                v6.setOnClickListener(this);
                break;

            case 8:
                View v7 = vi.inflate(R.layout.layout_tab_statistic, null);
                llMenu.addView(v7);
                v7.setOnClickListener(this);
                break;
            case 9:
                View v8 = vi.inflate(R.layout.layout_tab_work, null);
                llMenu.addView(v8);
                v8.setOnClickListener(this);
                break;



        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rlTabSign:
                Fragment sign = RootSignFragment.newIntance();
                changeTab(sign);
                break;
            case R.id.rlTabDocument:
                Fragment document = RootDocumentFragment.newIntance();
                changeTab(document);
                break;
            case R.layout.layout_tab_calendar:
                break;
            case R.layout.layout_tab_chart:
                break;
            case R.layout.layout_tab_contact:
                Fragment contact = RootContactFragment.newIntance();
                changeTab(contact);
                break;
            case R.layout.layout_tab_more:
                Fragment more = RootMoreFragment.newIntance();
                changeTab(more);
                break;
            case R.layout.layout_tab_work:
                Fragment work = RootContactFragment.newIntance();
                changeTab(work);
                break;
        }
        updateSelectTab();
        
    }

    private void updateSelectTab() {
        if(rlTabSign!=null){
            rlTabSign.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

        }

    }


    public void changeTab(Fragment fragment) {
//        if (currentTab.equalsIgnoreCase(tabId)) {
//            return;
//        }
//        currentTab = tabId;
//        map.put(tabId, fragment);
        String backStateName = fragment.getClass().getName();
        FragmentManager frManager = getSupportFragmentManager();
        boolean frPoped = frManager.popBackStackImmediate(backStateName, 0);
        FragmentTransaction replace = frManager.beginTransaction().replace(
                R.id.frameContent, fragment);
//        if (!frPoped) {
//            replace.addToBackStack(tabId);
//        }
        replace.commit();
      //  updateTabColor();
    }
}
