package com.viettel.voffice.tablet.fragment.contact;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.fragment.contact.adapter.ContactAdapter;
import com.viettel.voffice.tablet.fragment.contact.Object.ListContactObj;
import com.viettel.voffice.tablet.fragment.document.adapter.ListDoccumentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {
    RecyclerView lvContact;
    ArrayList<ListContactObj> arrContact;
    ContactAdapter adapter;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newIntance() {
        //isHideActionBar1 = isHideActionBar;
        return new ContactFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        setRecycle(v);
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        adapter.notifyDataSetChanged();

    }

    private void setRecycle(View v) {
        lvContact = v.findViewById(R.id.rc_view);
        lvContact.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lvContact.setHasFixedSize(true);
        lvContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrContact = new ArrayList<>();
        adapter = new ContactAdapter(getActivity(),arrContact);
        lvContact.setAdapter(adapter);

    }

}
