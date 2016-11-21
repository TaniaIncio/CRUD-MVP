package com.tincio.example.projectnotes.presentation.presenter;

import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.domain.callback.ListNoteCallback;
import com.tincio.example.projectnotes.domain.interactor.ListNoteInteractor;
import com.tincio.example.projectnotes.presentation.ListNotesContract;

import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public class ListNotePresenter implements ListNotesContract.ListNoteUserListener, ListNoteCallback {

    ListNotesContract.ListNoteView view;
    ListNoteInteractor interactor;

    public ListNotePresenter(ListNotesContract.ListNoteView view){
        this.view = view;
        interactor = new ListNoteInteractor(this);
    }
    @Override
    public void loadNote(Boolean boleano) {
        view.showIndicatorProgress(true);
        interactor.getListNote();
    }

    @Override
    public void addNewNote() {

    }

    @Override
    public void loadDetailNote() {

    }

    @Override
    public void responseNotes(List<Note> list) {
        view.showIndicatorProgress(false);
        view.showNotes(list);
    }
}
