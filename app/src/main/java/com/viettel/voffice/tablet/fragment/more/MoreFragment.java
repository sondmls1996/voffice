package com.viettel.voffice.tablet.fragment.more;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.SignFragment;
import com.viettel.voffice.tablet.model.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {
    LayoutInflater vi;
    LinearLayout lnMore,llOption,llData,llChangePass;
    RelativeLayout rlLeft,rlRight;
    public MoreFragment() {
        // Required empty public constructor
    }

    public static MoreFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new MoreFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_more, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lnMore = v.findViewById(R.id.ln_more_left);

        for (int i = 0; i<3;i++){
            addMenu(i);
        }
    }

    private void addMenu(int i) {
        switch (i){
            case 0:
                View cauhinh = vi.inflate(R.layout.more_item_cauhinh, null);
                llOption = cauhinh.findViewById(R.id.ll_option);
                lnMore.addView(llOption);
                llOption.setOnClickListener(this);
                break;
            case 1:
                View changepass = vi.inflate(R.layout.more_item_changepass, null);
                llChangePass = changepass.findViewById(R.id.ll_changepass);
                lnMore.addView(llChangePass);
                llChangePass.setOnClickListener(this);


                break;
            case 2:
                View data = vi.inflate(R.layout.more_item_data, null);
                llData = data.findViewById(R.id.ll_data);
                lnMore.addView(llData);
                llData.setOnClickListener(this);
                break;
        }
    }

    @Override
    public void onClick(View view) {

    }
}
