package com.viettel.voffice.tablet.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.RootCalendalFragment;
import com.viettel.voffice.tablet.fragment.RootChartFragment;
import com.viettel.voffice.tablet.fragment.RootContactFragment;
import com.viettel.voffice.tablet.fragment.RootDocumentFragment;
import com.viettel.voffice.tablet.fragment.RootMoreFragment;
import com.viettel.voffice.tablet.fragment.RootSignFragment;
import com.viettel.voffice.tablet.fragment.RootStatisticFragment;
import com.viettel.voffice.tablet.fragment.RootTransMoney;
import com.viettel.voffice.tablet.fragment.RootWorkFragment;
import com.viettel.voffice.tablet.fragment.calendal.CalendalFragment;
import com.viettel.voffice.tablet.model.Constant;


public class Voffice extends AppCompatActivity implements View.OnClickListener {
    LinearLayout llMenu;
    RelativeLayout rlMenuRight;
    ImageView imgTabSign,imgTabDoccument,imgTabMore,imgTabStatic,imgTabContact,
            imgTabCalendal,imgTabChart,imgTabTransMoney,imgTabWork;
    TextView tvTabSign,tvTabDoccument,tvTabMore,tvTabStatic,
            tvTabContact,tvTabCalendal,tvTabChart,tvTabTransMoney,
            tvTabWork;
    LayoutInflater vi;
    TextView tvTitleLeft, tvTitleRight;
    RelativeLayout rlToolbarLeft, rlToolBarRight;
    BroadcastReceiver broadcastChangeTitle;
    RelativeLayout rlTabSign,rlTabDoccument,rlTabMore,rlTabStatic,rlTabContact,rlTabCalendal,rlTabChart,rlTabTransMoney,rlTabWork;
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
        rlToolbarLeft = findViewById(R.id.rl_toolbar_left);
        rlToolBarRight = findViewById(R.id.rl_toolbar_right);
        tvTitleLeft = findViewById(R.id.tv_title_left);
        tvTitleRight = findViewById(R.id.tv_title_right);
         vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0;i<10; i ++){
         addTab(i);
        }
        View v = vi.inflate(R.layout.layout_tab_more, null);
        rlTabMore = v.findViewById(R.id.rlTabMore);
        imgTabMore = v.findViewById(R.id.imv_more);
        tvTabMore = v.findViewById(R.id.tv_title_more);
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
    private void addTab(int i) {

        switch (i){
            case 1:

                View v = vi.inflate(R.layout.layout_tab_sign, null);
                rlTabSign = v.findViewById(R.id.rlTabSign);
                tvTabSign = v.findViewById(R.id.tv_title_sign);
                imgTabSign = v.findViewById(R.id.imv_sign);
                llMenu.addView(v);
                rlTabSign.setOnClickListener(this);
                break;
            case 2:
                View v1 = vi.inflate(R.layout.layout_tab_document, null);
                rlTabDoccument = v1.findViewById(R.id.rlTabDocument);
                tvTabDoccument = v1.findViewById(R.id.tv_title_document);
                imgTabDoccument = v1.findViewById(R.id.imv_doc);
                llMenu.addView(v1);
                rlTabDoccument.setOnClickListener(this);
                break;
            case 3:
                View v2 = vi.inflate(R.layout.layout_tab_calendar, null);
                rlTabCalendal = v2.findViewById(R.id.rlTabCalendar);
                tvTabCalendal = v2.findViewById(R.id.tv_title_calendar);
                imgTabCalendal = v2.findViewById(R.id.imv_calendar);
                llMenu.addView(v2);
                v2.setOnClickListener(this);
                break;
            case 4:
                View v3 = vi.inflate(R.layout.layout_tab_chart, null);
                rlTabChart = v3.findViewById(R.id.rlTabChart);
                tvTabChart = v3.findViewById(R.id.tv_title_Chart);
                imgTabChart = v3.findViewById(R.id.imv_Chart);
                llMenu.addView(v3);
                v3.setOnClickListener(this);
                break;
            case 5:
                View v4 = vi.inflate(R.layout.layout_tab_contact, null);
                rlTabContact = v4.findViewById(R.id.rlTabContact);
                tvTabContact = v4.findViewById(R.id.tv_title_contact);
                imgTabContact = v4.findViewById(R.id.imv_contact);
                llMenu.addView(v4);
                rlTabContact.setOnClickListener(this);
                break;
            case 6:
                View v5 = vi.inflate(R.layout.layout_tab_reiview, null);

                llMenu.addView(v5);
              //  rlTabWork.setOnClickListener(this);
                break;
            case 7:
                View v7 = vi.inflate(R.layout.layout_tab_statistic, null);
                rlTabStatic = v7.findViewById(R.id.rlTabStatistic);
                tvTabStatic = v7.findViewById(R.id.tv_title_Statistic);
                imgTabStatic = v7.findViewById(R.id.imv_Statistic);
                llMenu.addView(v7);
                rlTabStatic.setOnClickListener(this);
                break;
            case 8:
                View v8 = vi.inflate(R.layout.layout_tab_work, null);
                rlTabWork = v8.findViewById(R.id.rlTabWork);
                tvTabWork= v8.findViewById(R.id.tv_title_work);
                imgTabWork = v8.findViewById(R.id.imvTabWork);
                llMenu.addView(v8);
                rlTabWork.setOnClickListener(this);
                break;
            case 9:
                View v9 = vi.inflate(R.layout.layout_tab_transmoney, null);
                rlTabTransMoney = v9.findViewById(R.id.rlTabTransMoney);
                tvTabTransMoney= v9.findViewById(R.id.tv_title_trans_money);
                imgTabTransMoney = v9.findViewById(R.id.imv_trans_money);
                llMenu.addView(v9);
                rlTabTransMoney.setOnClickListener(this);
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
            case R.id.rlTabCalendar:
                Fragment calendal = RootCalendalFragment.newInstance();
                changeTab(calendal);
                break;
            case R.id.rlTabStatistic:
                Fragment statics = RootStatisticFragment.newIntance();
                changeTab(statics);
                break;
            case R.id.rlTabContact:
                Fragment contact = RootContactFragment.newIntance();
                changeTab(contact);
                break;
            case R.id.rlTabMore:
                Fragment more = RootMoreFragment.newIntance();
                changeTab(more);
                break;
            case R.id.rlTabWork:
                Fragment work = RootWorkFragment.newIntance();
                changeTab(work);
                break;
            case R.id.rlTabTransMoney:
                Fragment trans = RootTransMoney.newIntance();
                changeTab(trans);
                break;
            case R.id.rlTabChart:
                Fragment chart = RootChartFragment.newIntance();
                changeTab(chart);
                break;

        }
        updateSelectTab(view);
        
    }

    private void updateSelectTab(View v) {
        if(rlTabSign!=null){
            rlTabSign.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabSign.setImageDrawable(getResources().getDrawable(R.drawable.menu_kyvb_w));
        }
        if(rlTabChart!=null){
            rlTabChart.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabChart.setImageDrawable(getResources().getDrawable(R.drawable.menu_bieudo));
        }
        if(rlTabDoccument!=null){
            rlTabDoccument.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabDoccument.setImageDrawable(getResources().getDrawable(R.drawable.menu_congvan_w));
        }if(rlTabContact!=null){
            rlTabContact.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabContact.setImageDrawable(getResources().getDrawable(R.drawable.menu_danhba_w));
        }
        if(rlTabCalendal!=null){
            rlTabCalendal.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabCalendal.setImageDrawable(getResources().getDrawable(R.drawable.menu_lich_w));
        }
        if(rlTabStatic!=null){
            rlTabStatic.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabStatic.setImageDrawable(getResources().getDrawable(R.drawable.menu_bieudo));
        }
        if(rlTabWork!=null){
            rlTabWork.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabWork.setImageDrawable(getResources().getDrawable(R.drawable.menu_congviec_w));
        }
        if(rlTabTransMoney!=null){
            rlTabTransMoney.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));

            imgTabTransMoney.setImageDrawable(getResources().getDrawable(R.drawable.menu_kyct_w));
        }
        if(rlTabMore!=null){
            rlTabMore.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));
            imgTabMore.setImageDrawable(getResources().getDrawable(R.drawable.menu_caidat_w));
        }

        if(rlTabStatic!=null){
            rlTabStatic.setBackgroundColor(getResources().getColor(R.color.BLUE_DARK));
            imgTabStatic.setImageDrawable(getResources().getDrawable(R.drawable.menu_thongke_w));
        }

        switch (v.getId()){
            case R.id.rlTabSign:
                 rlTabSign.setBackgroundColor(getResources().getColor(R.color.BLUE));
                 imgTabSign.setImageDrawable(getResources().getDrawable(R.drawable.menu_kyvb_w_click));
                break;
            case R.id.rlTabDocument:
                rlTabDoccument.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabDoccument.setImageDrawable(getResources().getDrawable(R.drawable.menu_congvan_w_click));
                break;
            case R.id.rlTabCalendar:
                rlTabCalendal.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabCalendal.setImageDrawable(getResources().getDrawable(R.drawable.menu_lich_w_click));
                break;
            case R.id.rlTabStatistic:
                rlTabStatic.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabStatic.setImageDrawable(getResources().getDrawable(R.drawable.menu_thongke_w_click));
                break;
            case R.id.rlTabContact:
                rlTabContact.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabContact.setImageDrawable(getResources().getDrawable(R.drawable.menu_danhba_w_click));
                break;
            case R.id.rlTabMore:
                rlTabMore.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabMore.setImageDrawable(getResources().getDrawable(R.drawable.menu_caidat_w_click));
                break;
            case R.id.rlTabWork:
                rlTabWork.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabWork.setImageDrawable(getResources().getDrawable(R.drawable.menu_congviec_w_click));
                break;
            case R.id.rlTabTransMoney:
                rlTabTransMoney.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabTransMoney.setImageDrawable(getResources().getDrawable(R.drawable.menu_kyct_w_click));
                break;
            case R.id.rlTabChart:
                rlTabChart.setBackgroundColor(getResources().getColor(R.color.BLUE));
                imgTabChart.setImageDrawable(getResources().getDrawable(R.drawable.menu_bieudo_w_click));
                break;

        }

    }

    @Override
    protected void onResume() {
        if(broadcastChangeTitle==null){
            registerBoradcastChangeTitle();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        unregisterBroadcastChangeTitle();
        super.onStop();
    }

    private void unregisterBroadcastChangeTitle() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(broadcastChangeTitle);
        broadcastChangeTitle = null;
    }

    private void registerBoradcastChangeTitle() {
        broadcastChangeTitle = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(Constant.CHANGETITLE_ACTION)){

                }
            }
        };

        IntentFilter it = new IntentFilter();
        it.addAction(Constant.CHANGETITLE_ACTION);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(broadcastChangeTitle,it);
    }

    public void changeTab(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager frManager = getSupportFragmentManager();
        boolean frPoped = frManager.popBackStackImmediate(backStateName, 0);
        FragmentTransaction replace = frManager.beginTransaction().replace(
                R.id.frameContent, fragment);

        replace.commit();

    }

}
