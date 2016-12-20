package com.tincio.example.projectnotes.presentation.view;


import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tincio.example.projectnotes.R;
import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.presentation.ListNotesContract;
import com.tincio.example.projectnotes.presentation.adapter.ListNoteAdapter;
import com.tincio.example.projectnotes.presentation.presenter.ListNotePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListNotesFragment extends Fragment implements ListNotesContract.ListNoteView,
        SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.rcv_notes)
    RecyclerView rcvNotes;
    RecyclerView.LayoutManager layoutManager;
    ListNoteAdapter adapter;
    ListNotesContract.ListNoteUserListener presenter;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.lbl_error)
    TextView lblError;
    private static final String TAG = ListNotesFragment.class.getSimpleName();
    public ListNotesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_notes, container, false);
        ButterKnife.bind(this,view);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.add_note);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });
        layoutManager = new GridLayoutManager(getActivity(),2);
        rcvNotes.setLayoutManager(layoutManager);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new ListNotePresenter(this);
        presenter.loadNote(true);
        adapter.onItemClickAdapter(new ListNoteAdapter.ListNoteAdapterOnClickHandler() {
            @Override
            public void onItemClick(Note mNote) {

            }
        });
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
        if(list.size()==0)
            lblError.setVisibility(View.VISIBLE);
        else
            lblError.setVisibility(View.GONE);
    }

    @Override
    public void addNote() {

    }

    void changeFragment(){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_notes, new AddNoteFragment());
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void showDetails() {

    }

    @Override
    public void onRefresh() {
        presenter.loadNote(true);
    }
}
