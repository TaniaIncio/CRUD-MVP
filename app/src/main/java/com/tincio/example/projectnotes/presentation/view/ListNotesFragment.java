package com.tincio.example.projectnotes.presentation.view;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tincio.example.projectnotes.R;
import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.presentation.ListNotesContract;
import com.tincio.example.projectnotes.presentation.adapter.ListNoteAdapter;
import com.tincio.example.projectnotes.presentation.presenter.ListNotePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListNotesFragment extends Fragment implements ListNotesContract.ListNoteView{

    RecyclerView rcvNotes;
    RecyclerView.LayoutManager layoutManager;
    ListNoteAdapter adapter;
    ListNotesContract.ListNoteUserListener presenter;
    SwipeRefreshLayout swipeRefreshLayout;
    public ListNotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_notes, container, false);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.add_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        rcvNotes = (RecyclerView)view.findViewById(R.id.rcv_notes);
        layoutManager = new GridLayoutManager(getActivity(),2);
        rcvNotes.setLayoutManager(layoutManager);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadNote(true);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new ListNotePresenter(this);
        presenter.loadNote(true);
    }

    @Override
    public void showIndicatorProgress(final Boolean boleano) {
        if(getView()==null){
            return;
        }
        final SwipeRefreshLayout srl =
                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(boleano);
            }
        });


    }

    @Override
    public void showNotes(List<Note> list) {
        adapter = new ListNoteAdapter(list);
        rcvNotes.setAdapter(adapter);
    }

    @Override
    public void addNote() {

    }

    @Override
    public void showDetails() {

    }
}
