package com.viettel.voffice.tablet.fragment.document.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentUnreadObj;

import java.util.ArrayList;

public class ListDoccumentUnread extends ArrayAdapter<ListDoccumentUnreadObj> {
    Context ct;

    public ListDoccumentUnread(Context context, int resource, ArrayList<ListDoccumentUnreadObj> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ListDoccumentUnreadObj doccumentObj = getItem(position);
        if(v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v =  inflater.inflate(R.layout.item_doccument, null);
        }
        init(v);
//        SwipeLayout swipe = v.findViewById(R.id.sign_item_swipe);
//        swipe.addDrag(SwipeLayout.DragEdge.Right, v.findViewById(R.id.bottom_wrapper));
        return v;
    }

    private void init(View v) {
        RelativeLayout rlSaveCV = v.findViewById(R.id.icon_save_cv);
        RelativeLayout rlCreateTask = v.findViewById(R.id.icon_create_task);
        RelativeLayout rlForwardCV = v.findViewById(R.id.icon_forward_cv);
        RelativeLayout rlAttFile = v.findViewById(R.id.icon_attfile);
        ImageView imginfo = v.findViewById(R.id.img_info);
        ImageView dot = v.findViewById(R.id.img_dot);
     //   rlSaveCV.setVisibility(View.VISIBLE);
        imginfo.setVisibility(View.VISIBLE);
        dot.setVisibility(View.VISIBLE);
        rlCreateTask.setVisibility(View.VISIBLE);
        rlForwardCV.setVisibility(View.VISIBLE);
        rlAttFile.setVisibility(View.VISIBLE);

    }
}

