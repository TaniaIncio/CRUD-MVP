package com.tincio.example.projectnotes.data.repository;

import com.tincio.example.projectnotes.data.model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public class ListNoteRepository {
    List<Note> list;
    public List<Note> getNotes(){
        if(list==null){
            list = new ArrayList<>();
        }
        list.add(new Note("Hola","Hola a Todos"));
        list.add(new Note("Hola","Hola a Todos 2"));
        return list;
    }
}
