package com.tincio.example.projectnotes.presentation;

import com.tincio.example.projectnotes.data.model.Note;

import java.util.List;

/**
 * Created by tincio on 16/12/16.
 */

public interface AddNotesContract {

    public interface AddNoteView{
        void addNote();
    }
    public interface AddNoteUserListener{
        void addNewNote();
    }
}
