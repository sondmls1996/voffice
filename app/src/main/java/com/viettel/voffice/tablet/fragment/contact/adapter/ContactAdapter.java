package com.viettel.voffice.tablet.fragment.contact.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.squareup.picasso.Picasso;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.contact.Object.ListContactObj;
import com.viettel.voffice.tablet.fragment.contact.adapter.ContactAdapter;
import com.viettel.voffice.tablet.fragment.contact.adapter.ContactAdapter;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentObj;
import com.viettel.voffice.tablet.model.TransImage;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerSwipeAdapter<ContactAdapter.SimpleViewHolder> {

public static class SimpleViewHolder extends RecyclerView.ViewHolder {
    ImageView imgAvt;
    RelativeLayout mail;
    RelativeLayout sms;
    SwipeLayout swipeLayout;
    public SimpleViewHolder(View v) {
        super(v);
         imgAvt = v.findViewById(R.id.img_avatar);

         mail = v.findViewById(R.id.icon_mail);
         sms = v.findViewById(R.id.icon_sms);
         swipeLayout = v.findViewById(R.id.sign_item_swipe);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d(getClass().getSimpleName(), "onItemSelected: " + textViewData.getText().toString());
//                    Toast.makeText(view.getContext(), "onItemSelected: " + textViewData.getText().toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
    }
}

    private Context mContext;
    private ArrayList<ListContactObj> mDataset;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    public ContactAdapter(Context context, ArrayList<ListContactObj> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public ContactAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactAdapter.SimpleViewHolder viewHolder, final int position) {
        ListContactObj item = mDataset.get(position);

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        viewHolder.mail.setVisibility(View.VISIBLE);
        viewHolder.sms.setVisibility(View.VISIBLE);
        Picasso.get().load(R.drawable.female).transform(new TransImage()).into(viewHolder.imgAvt);
        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.sign_item_swipe;
    }
}
