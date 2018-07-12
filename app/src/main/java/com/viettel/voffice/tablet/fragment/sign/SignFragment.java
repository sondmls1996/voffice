package com.viettel.voffice.tablet.fragment.sign;


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
import com.viettel.voffice.tablet.fragment.sign.Obj.SignListObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment implements View.OnClickListener {

    LinearLayout llMenuLeft;

    LayoutInflater vi;
    RelativeLayout rlWait,rlSigned,rlUnSign,rlFlash,rlUnFlash,rlFlashed,rlUserUnsign,rlAll,rlRelease;
    ArrayList<SignListObj> arraySign;
    View v;
    public SignFragment() {
        // Required empty public constructor
    }

    public static SignFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new SignFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sign, container, false);
        init(v);
        rlWait.performClick();
        return v;
    }

    private void init(View v) {
         vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llMenuLeft = v.findViewById(R.id.ll_menu_left);

        for (int i = 0; i<9;i++){
            addTab(i);
        }
    }

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.sign_item_wait, null);
                rlWait = v.findViewById(R.id.rlMenuWait);
                llMenuLeft.addView(v);
                rlWait.setOnClickListener(this);
                break;
            case 1:
                View v2 = vi.inflate(R.layout.sign_item_flash_sign, null);
                rlFlash = v2.findViewById(R.id.rlMenuFlashSign);
                llMenuLeft.addView(v2);
                rlFlash.setOnClickListener(this);
                break;
            case 2:
                View v3 = vi.inflate(R.layout.sign_item_has_sign, null);
                rlSigned = v3.findViewById(R.id.rlMenuHasSign);
                llMenuLeft.addView(v3);
                rlSigned.setOnClickListener(this);
                break;
            case 3:
                View v4 = vi.inflate(R.layout.sign_item_has_flashsign, null);
                rlFlashed = v4.findViewById(R.id.rlMenuHasFlashSign);
                llMenuLeft.addView(v4);
                rlFlashed.setOnClickListener(this);
                break;
                case 4:
                    View v5 = vi.inflate(R.layout.sign_item_notsign, null);
                    rlUnSign = v5.findViewById(R.id.rlMenuNotsign);
                    llMenuLeft.addView(v5);
                    rlUnSign.setOnClickListener(this);
                break;
                case 5:
                    View v6 = vi.inflate(R.layout.sign_item_notflashsign, null);
                    rlUnFlash = v6.findViewById(R.id.rlMenuNotFlashSign);
                    llMenuLeft.addView(v6);
                    rlUnFlash.setOnClickListener(this);
                break;
                case 6:
                    View v7= vi.inflate(R.layout.sign_item_uer_notsign, null);
                    rlUserUnsign = v7.findViewById(R.id.rlMenuUserNotSign);
                    llMenuLeft.addView(v7);
                    rlUserUnsign.setOnClickListener(this);
                break;
            case 7:
                View v8= vi.inflate(R.layout.sign_item_release, null);
                rlRelease = v8.findViewById(R.id.rlMenuRelease);
                llMenuLeft.addView(v8);
                rlRelease.setOnClickListener(this);
                break;
            case 8:
                View v9= vi.inflate(R.layout.sign_item_all, null);
                rlAll = v9.findViewById(R.id.rlMenuAll);
                llMenuLeft.addView(v9);
                rlAll.setOnClickListener(this);
                break;

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rlMenuWait:
                Class wait = FragmentSignWait.class;
                replaceFragment(wait);
                break;
            case R.id.rlMenuFlashSign:
                Class flash = FragmentFlashSign.class;
                replaceFragment(flash);
                break;
            case R.id.rlMenuHasSign:
                Class signed = FragmentSigned.class;
                replaceFragment(signed);
                break;
            case R.id.rlMenuHasFlashSign:
                Class flashSigned = FragmentFlashSigned.class;
                replaceFragment(flashSigned);
                break;
            case R.id.rlMenuNotsign:
                Class unsign = FragmentUnsign.class;
                replaceFragment(unsign);
                break;
            case R.id.rlMenuNotFlashSign:
                Class unflashsign = FragmentUnflashSign.class;
                replaceFragment(unflashsign);
                break;
            case R.id.rlMenuUserNotSign:
                Class signAfter = FragmentSignafter.class;
                replaceFragment(signAfter);
                break;
            case R.id.rlMenuRelease:
                Class release = FragmentRelease.class;
                replaceFragment(release);
                break;
            case R.id.rlMenuAll:
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
                fragmentManager.beginTransaction().replace(R.id.content_sign, fragment).commitAllowingStateLoss();

    }
}
