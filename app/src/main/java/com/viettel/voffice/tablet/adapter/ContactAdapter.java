package com.viettel.voffice.tablet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;
import com.squareup.picasso.Picasso;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.model.Object.ListContactObj;
import com.viettel.voffice.tablet.model.Object.ListDoccumentObj;
import com.viettel.voffice.tablet.model.Object.ListContactObj;
import com.viettel.voffice.tablet.model.TransImage;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<ListContactObj> {
    Context ct;
    ArrayAdapter<ListContactObj> array;

    public ContactAdapter(Context context, int resource, ArrayList<ListContactObj> items) {

        super(context, resource, items);
        this.ct = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ListContactObj contactObj = getItem(position);
        if(v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v =  inflater.inflate(R.layout.item_contact, null);
        }
        ImageView imgAvt = v.findViewById(R.id.img_avatar);
        Picasso.get().load(R.drawable.female).transform(new TransImage()).into(imgAvt);
        init();

        return v;
    }

    private void init() {

    }
}
