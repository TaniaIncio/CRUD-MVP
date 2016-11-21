package com.tincio.example.projectnotes.domain.callback;

import com.tincio.example.projectnotes.data.model.Note;

import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public interface ListNoteCallback {

    public void responseNotes(List<Note> list);
}
