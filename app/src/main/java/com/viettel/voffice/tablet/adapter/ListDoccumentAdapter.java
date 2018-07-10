package com.viettel.voffice.tablet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.daimajia.swipe.SwipeLayout;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.model.Object.ListDoccumentObj;
import com.viettel.voffice.tablet.model.Object.ListSignObject;

import java.util.ArrayList;

public class ListDoccumentAdapter extends ArrayAdapter<ListDoccumentObj> {
    Context ct;

    public ListDoccumentAdapter(Context context, int resource, ArrayList<ListDoccumentObj> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ListDoccumentObj doccumentObj = getItem(position);
        if(v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v =  inflater.inflate(R.layout.item_doccument, null);
        }
        init();
        SwipeLayout swipe = v.findViewById(R.id.sign_item_swipe);
        swipe.addDrag(SwipeLayout.DragEdge.Right, v.findViewById(R.id.bottom_wrapper));
        return v;
    }

    private void init() {

    }
}
