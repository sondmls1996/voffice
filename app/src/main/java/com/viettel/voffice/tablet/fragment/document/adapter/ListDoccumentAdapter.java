package com.viettel.voffice.tablet.fragment.document.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentObj;

import java.util.ArrayList;

public class ListDoccumentAdapter extends RecyclerSwipeAdapter<ListDoccumentAdapter.SimpleViewHolder> {

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlSaveCV;
        RelativeLayout rlCreateTask;
        RelativeLayout rlForwardCV;
        ImageView inginfo;
        RelativeLayout rlAttFile;
        SwipeLayout swipeLayout;
        public SimpleViewHolder(View v) {
            super(v);
             rlSaveCV = v.findViewById(R.id.icon_save_cv);
             rlCreateTask = v.findViewById(R.id.icon_create_task);
             rlForwardCV = v.findViewById(R.id.icon_forward_cv);
             rlAttFile = v.findViewById(R.id.icon_attfile);
             inginfo = v.findViewById(R.id.img_info);
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
    private ArrayList<ListDoccumentObj> mDataset;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);
    public ListDoccumentAdapter(Context context, ArrayList<ListDoccumentObj> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public ListDoccumentAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doccument, parent, false);
        return new ListDoccumentAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListDoccumentAdapter.SimpleViewHolder viewHolder, final int position) {
        ListDoccumentObj item = mDataset.get(position);

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        viewHolder.rlSaveCV.setVisibility(View.VISIBLE);
        viewHolder.rlCreateTask.setVisibility(View.VISIBLE);
        viewHolder.rlForwardCV.setVisibility(View.VISIBLE);
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
