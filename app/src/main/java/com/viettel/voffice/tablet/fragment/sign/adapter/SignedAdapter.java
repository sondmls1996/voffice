package com.viettel.voffice.tablet.fragment.sign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignedListObj;

import java.util.ArrayList;

public class SignedAdapter extends RecyclerSwipeAdapter<SignedAdapter.SimpleViewHolder> {

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView img_ngkycuoi;
        ImageView img_cmt;
        SwipeLayout swipeLayout;
        LinearLayout lnContent;
        RelativeLayout rlAttFile;
        public SimpleViewHolder(View v) {
            super(v);
             img_ngkycuoi = v.findViewById(R.id.img_ngkycuoi);
             img_cmt = v.findViewById(R.id.img_cmt);
             lnContent = v.findViewById(R.id.ln_content);
            rlAttFile = v.findViewById(R.id.icon_attfile);
            swipeLayout = v.findViewById(R.id.sign_item_swipe);
        }
    }

    private Context mContext;
    private ArrayList<SignedListObj> mDataset;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    public SignedAdapter(Context context, ArrayList<SignedListObj> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public SignedAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sign, parent, false);
        return new SignedAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SignedAdapter.SimpleViewHolder viewHolder, final int position) {
        SignedListObj item = mDataset.get(position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.lnContent.setVisibility(View.VISIBLE);
        viewHolder.img_ngkycuoi.setVisibility(View.VISIBLE);
        viewHolder.img_cmt.setVisibility(View.VISIBLE);
        viewHolder.rlAttFile.setVisibility(View.VISIBLE);
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
