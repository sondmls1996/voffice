package com.viettel.voffice.tablet.fragment.sign.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.sign.Obj.FlashSignListObj;
import com.viettel.voffice.tablet.fragment.sign.Obj.FlashSignListObj;

import java.util.ArrayList;

public class ListFlashSignAdapter extends RecyclerSwipeAdapter<ListFlashSignAdapter.SimpleViewHolder> {

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView img_ngkycuoi;
        LinearLayout lnContent;
        RelativeLayout rlSign;
        RelativeLayout rlAttFile;
        SwipeLayout swipeLayout;
        public SimpleViewHolder(View v) {
            super(v);
             img_ngkycuoi = v.findViewById(R.id.img_ngkycuoi);
             lnContent = v.findViewById(R.id.ln_content);

             rlSign = v.findViewById(R.id.icon_sign);
             rlAttFile = v.findViewById(R.id.icon_attfile);
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
    private ArrayList<FlashSignListObj> mDataset;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    public ListFlashSignAdapter(Context context, ArrayList<FlashSignListObj> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public ListFlashSignAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sign, parent, false);
        return new ListFlashSignAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListFlashSignAdapter.SimpleViewHolder viewHolder, final int position) {
        FlashSignListObj item = mDataset.get(position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.lnContent.setVisibility(View.VISIBLE);
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
