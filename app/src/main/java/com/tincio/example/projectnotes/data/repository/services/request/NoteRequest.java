package com.tincio.example.projectnotes.data.repository.services.request;

/**
 * Created by tania on 21/12/2016.
 */

public class NoteRequest {

    private String consulta;

    public NoteRequest() {}
    public NoteRequest(String consulta) {
        this.consulta = consulta;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
}
