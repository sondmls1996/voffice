package com.viettel.voffice.tablet.fragment.contact;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.viettel.voffice.tablet.R;
import com.viettel.voffice.tablet.adapter.ContactAdapter;
import com.viettel.voffice.tablet.fragment.document.DoccumentListFragment;
import com.viettel.voffice.tablet.model.Object.ListContactObj;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {
    ListView lvContact;
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
        lvContact = v.findViewById(R.id.lv_contact);
        arrContact = new ArrayList<>();
        adapter = new ContactAdapter(getActivity(),R.layout.item_contact,arrContact);
        lvContact.setAdapter(adapter);
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        arrContact.add(new ListContactObj());
        adapter.notifyDataSetChanged();

    }

}
