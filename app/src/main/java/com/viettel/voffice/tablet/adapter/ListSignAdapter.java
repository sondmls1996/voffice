package com.viettel.voffice.tablet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.daimajia.swipe.SwipeLayout;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.model.Object.ListSignObject;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ListSignAdapter extends ArrayAdapter<ListSignObject> {
    Context ct;
    ArrayAdapter<ListSignObject> array;

    public ListSignAdapter(Context context, int resource, ArrayList<ListSignObject> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ListSignObject pill = getItem(position);
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
        RelativeLayout rlForward = v.findViewById(R.id.icon_forward_sign);
        RelativeLayout rlSign = v.findViewById(R.id.icon_sign);
        RelativeLayout rlAttFile = v.findViewById(R.id.icon_attfile);
        rlForward.setVisibility(View.VISIBLE);
        rlSign.setVisibility(View.VISIBLE);
        rlAttFile.setVisibility(View.VISIBLE);

    }
}