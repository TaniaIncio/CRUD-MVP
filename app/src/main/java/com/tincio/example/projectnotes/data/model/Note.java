package com.tincio.example.projectnotes.data.model;

import android.support.annotation.Nullable;

import java.util.UUID;

/**
 * Created by juan on 26/10/2016.
 */

public final class Note {

    private final String id;
    @Nullable
    private final String title;
    @Nullable
    private final String description;


    public Note(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (!id.equals(note.id)) return false;
        if (!title.equals(note.title)) return false;
        return description.equals(note.description);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
