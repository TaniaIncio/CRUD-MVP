package com.tincio.example.projectnotes.presentation;

import com.tincio.example.projectnotes.data.model.Note;

import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public interface ListNotesContract {

    public interface ListNoteView{
        void showIndicatorProgress(Boolean boleano);
        void showNotes(List<Note> list);
        void addNote();
        void showDetails();
    }
    public interface ListNoteUserListener{
        void loadNote(Boolean boleano);
        void addNewNote();
        void loadDetailNote();
    }
}
