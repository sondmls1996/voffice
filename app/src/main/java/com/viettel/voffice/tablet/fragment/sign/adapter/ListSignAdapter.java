package com.viettel.voffice.tablet.fragment.sign.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignListObj;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListSignAdapter extends ArrayAdapter<SignListObj> {
    Context ct;
    ArrayAdapter<SignListObj> array;

    public ListSignAdapter(Context context, int resource, ArrayList<SignListObj> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        SignListObj pill = getItem(position);
        if(v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v =  inflater.inflate(R.layout.item_sign, null);
        }
        init(v);

//        SwipeLayout swipe = v.findViewById(R.id.sign_item_swipe);
//        swipe.addDrag(SwipeLayout.DragEdge.Right, v.findViewById(R.id.bottom_wrapper));
        return v;
    }

    private void init(View v) {
        TextView tv_thoigiantrinh = v.findViewById(R.id.tv_thoigiantrinh);
        TextView tv_time= v.findViewById(R.id.tv_time);
        ImageView img_ngkycuoi = v.findViewById(R.id.img_ngkycuoi);
        LinearLayout lnContent = v.findViewById(R.id.ln_content);

        RelativeLayout rlForward = v.findViewById(R.id.icon_forward_sign);
        RelativeLayout rlSign = v.findViewById(R.id.icon_sign);
        RelativeLayout rlAttFile = v.findViewById(R.id.icon_attfile);
        lnContent.setVisibility(View.VISIBLE);
        tv_thoigiantrinh.setVisibility(View.VISIBLE);
        tv_time.setVisibility(View.VISIBLE);
        rlForward.setVisibility(View.VISIBLE);
        img_ngkycuoi.setVisibility(View.VISIBLE);
        rlSign.setVisibility(View.VISIBLE);
        rlAttFile.setVisibility(View.VISIBLE);

    }
}