package com.tincio.example.projectnotes.data.repository.services;

import com.tincio.example.projectnotes.data.repository.services.request.NoteRequest;
import com.tincio.example.projectnotes.data.repository.services.response.NoteResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tincio on 21/12/2016.
 */

public interface NoteNetwork{
///"https://api.myjson.com/bins/eccqr
    String URL = "https://api.myjson.com/";

    @Headers("Content-Type:application/json")
    @GET("bins/{parametro}")
    Call<NoteResponse> getNotes(@Path("parametro") String parametro);

}
