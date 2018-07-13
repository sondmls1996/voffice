package com.viettel.voffice.tablet.fragment.document;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentObj;
import com.viettel.voffice.tablet.fragment.document.Object.ListDoccumentUnreadObj;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccument;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccumentUnread;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDocUnread extends Fragment {
    ListView lvSign;
    LinearLayout llMenuLeft;
    ListDoccumentUnread adapter;
    ArrayList<ListDoccumentUnreadObj> arraySign;

    public FragmentDocUnread() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doc_unread, container, false);
        init(v);
        return v;
    }
    private void init(View v) {
        lvSign = v.findViewById(R.id.rc_view);
        arraySign = new ArrayList<>();
        adapter = new ListDoccumentUnread(getActivity(),R.layout.item_doccument,arraySign);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        lvSign.setLayoutManager(layoutManager);
        lvSign.setAdapter(adapter);

        arraySign.add(new ListDoccumentUnreadObj());
        arraySign.add(new ListDoccumentUnreadObj());
        arraySign.add(new ListDoccumentUnreadObj());
        arraySign.add(new ListDoccumentUnreadObj());
        adapter.notifyDataSetChanged();
    }
}
