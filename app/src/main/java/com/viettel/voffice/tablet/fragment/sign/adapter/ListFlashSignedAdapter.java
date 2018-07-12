package com.viettel.voffice.tablet.fragment.sign.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.FlashSignedListObj;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignListObj;

import java.util.ArrayList;

public class ListFlashSignedAdapter extends ArrayAdapter<FlashSignedListObj> {
    Context ct;
    ArrayAdapter<SignListObj> array;

    public ListFlashSignedAdapter(Context context, int resource, ArrayList<FlashSignedListObj> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        FlashSignedListObj pill = getItem(position);
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

        ImageView img_ngkycuoi = v.findViewById(R.id.img_ngkycuoi);
        ImageView img_cmt = v.findViewById(R.id.img_cmt);

        LinearLayout lnContent = v.findViewById(R.id.ln_content);

        RelativeLayout rlSign = v.findViewById(R.id.icon_sign);
        RelativeLayout rlAttFile = v.findViewById(R.id.icon_attfile);
        lnContent.setVisibility(View.VISIBLE);

        img_cmt.setVisibility(View.VISIBLE);
        img_ngkycuoi.setVisibility(View.VISIBLE);

        rlAttFile.setVisibility(View.VISIBLE);

    }
}