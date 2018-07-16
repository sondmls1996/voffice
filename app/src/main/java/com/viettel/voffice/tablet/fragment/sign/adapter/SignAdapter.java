package com.viettel.voffice.tablet.fragment.sign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.SignListObj;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SignAdapter extends RecyclerSwipeAdapter<SignAdapter.SimpleViewHolder> {

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView tv_thoigiantrinh;
        TextView tv_time;
        ImageView img_ngkycuoi;
        LinearLayout lnContent;
        RelativeLayout rlForward;
        SwipeLayout swipeLayout;
        RelativeLayout rlSign;
        RelativeLayout rlAttFile;

        public SimpleViewHolder(View v) {
            super(v);
            tv_thoigiantrinh = v.findViewById(R.id.tv_thoigiantrinh);
            tv_time= v.findViewById(R.id.tv_time);
            img_ngkycuoi = v.findViewById(R.id.img_ngkycuoi);
            lnContent = v.findViewById(R.id.ln_content);
            swipeLayout = v.findViewById(R.id.sign_item_swipe);
            rlForward = v.findViewById(R.id.icon_forward_sign);
            rlSign = v.findViewById(R.id.icon_sign);
            rlAttFile = v.findViewById(R.id.icon_attfile);



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
    private ArrayList<SignListObj> mDataset;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    public SignAdapter(Context context, ArrayList<SignListObj> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public SignAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sign, parent, false);
        return new SignAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SignAdapter.SimpleViewHolder viewHolder, final int position) {
        SignListObj item = mDataset.get(position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.lnContent.setVisibility(View.VISIBLE);
        viewHolder.tv_thoigiantrinh.setVisibility(View.VISIBLE);
        viewHolder.tv_time.setVisibility(View.VISIBLE);
        viewHolder.rlForward.setVisibility(View.VISIBLE);
        viewHolder.img_ngkycuoi.setVisibility(View.VISIBLE);
        viewHolder.rlSign.setVisibility(View.VISIBLE);
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
