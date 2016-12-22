package com.tincio.example.projectnotes.data.repository;

import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.data.repository.services.NoteNetwork;
import com.tincio.example.projectnotes.data.repository.services.request.NoteRequest;
import com.tincio.example.projectnotes.data.repository.services.response.NoteResponse;
import com.tincio.example.projectnotes.domain.callback.ListNoteCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tania on 26/10/2016.
 */

public class ListNoteRepository {
    ListNoteCallback callback;

    public ListNoteRepository(ListNoteCallback callback){
        this.callback = callback;
    }

    public void getNotesNetwork(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NoteNetwork.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NoteRequest requestNote = new NoteRequest("nombre");
        NoteNetwork interfaces = retrofit.create(NoteNetwork.class);

        Call<NoteResponse> responseCall = interfaces.getNotes("eccqr");
        responseCall.enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                NoteResponse responseNote = response.body();
                if(responseNote.getIsSuccess()) {
                    callback.responseNotes(responseNote.getResult());
                }
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {

            }
        });
    }
}
