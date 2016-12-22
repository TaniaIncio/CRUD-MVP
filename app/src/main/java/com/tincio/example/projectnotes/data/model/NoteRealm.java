package com.tincio.example.projectnotes.data.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tania on 21/12/2016.
 */

public class NoteRealm extends RealmObject {
    @PrimaryKey
    private String id;
    private String title;
    private String description;

    public NoteRealm() {

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static List<NoteRealm> getNotesInDatabase(){
        return Realm.getDefaultInstance().where(NoteRealm.class)
                .findAll();
    }
}
