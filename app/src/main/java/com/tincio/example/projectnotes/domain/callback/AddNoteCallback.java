package com.tincio.example.projectnotes.domain.callback;

import com.tincio.example.projectnotes.data.model.Note;

import java.util.List;

/**
 * Created by tincio on 20/12/16.
 */

public interface AddNoteCallback {

    public void responseNotes(List<Note> list);
}
