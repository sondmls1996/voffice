package com.viettel.voffice.tablet.fragment.sign;


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
import com.viettel.voffice.tablet.adapter.ListSignAdapter;
import com.viettel.voffice.tablet.fragment.RootSignFragment;
import com.viettel.voffice.tablet.model.Object.ListSignObject;

import java.security.SignedObject;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment implements View.OnClickListener {
    ListView lvSign;
    LinearLayout llMenuLeft;
    ListSignAdapter adapter;
    LinearLayout ll_menu_left;
    LayoutInflater vi;
    RelativeLayout rlWait,rlSigned,rlUnSign,rlAll,rlRelease;
    ArrayList<ListSignObject> arraySign;
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
        return v;
    }

    private void init(View v) {
         vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llMenuLeft = v.findViewById(R.id.ll_menu_left);
        lvSign = v.findViewById(R.id.lv_sign);
        arraySign = new ArrayList<>();
        adapter = new ListSignAdapter(getActivity(),R.layout.item_sign,arraySign);
        ll_menu_left =  v.findViewById(R.id.ll_menu_left);

        for (int i = 0; i<6;i++){
            addTab(i);
        }
        lvSign.setAdapter(adapter);
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        arraySign.add(new ListSignObject());
        adapter.notifyDataSetChanged();
    }

    private void addTab(int i) {
        switch (i){
            case 0:
                View v = vi.inflate(R.layout.sign_item_wait, null);
                rlWait = v.findViewById(R.id.rlWait);
                llMenuLeft.addView(v);
                rlWait.setOnClickListener(this);
                break;
            case 1:
                View v2 = vi.inflate(R.layout.sign_item_wait, null);
                rlWait = v2.findViewById(R.id.rlWait);
                llMenuLeft.addView(v2);
                rlWait.setOnClickListener(this);
                break;
            case 2:
                View v3 = vi.inflate(R.layout.sign_item_wait, null);
                rlWait = v3.findViewById(R.id.rlWait);
                llMenuLeft.addView(v3);
                rlWait.setOnClickListener(this);
                break;
            case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 6:
                break;



        }
    }

    @Override
    public void onClick(View view) {

    }
}
