package com.tincio.example.projectnotes.domain.interactor;

import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.data.repository.ListNoteRepository;
import com.tincio.example.projectnotes.domain.callback.ListNoteCallback;

import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public class ListNoteInteractor {

    ListNoteRepository repository;
    ListNoteCallback callback;

    public ListNoteInteractor(ListNoteCallback callback){
        this.callback = callback;
    }
    public void getListNote(){
        repository = new ListNoteRepository(callback);
        repository.getNotesNetwork();
    }
}
