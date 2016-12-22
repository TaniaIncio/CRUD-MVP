package com.tincio.example.projectnotes.presentation.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tincio.example.projectnotes.R;
import com.tincio.example.projectnotes.presentation.view.contract.AddNotesContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNoteFragment extends Fragment implements AddNotesContract.AddNoteView {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_description)
    TextView txtDescription;

    public AddNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_note, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void addNote() {

    }
}
