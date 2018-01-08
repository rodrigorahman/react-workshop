package br.com.workshop.agendabackendapi.model;

import br.com.workshop.agendabackendapi.entity.AgendaCompromisso;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class AgendaRS implements Serializable{

    private String nomeAgenda;
    private List<AgendaCompromisso> compromissos;

    public AgendaRS(@JsonProperty("nomeAgenda") String nomeAgenda, @JsonProperty("compromissos") List<AgendaCompromisso> compromissos) {
        this.nomeAgenda = nomeAgenda;
        this.compromissos = compromissos;
    }

    public String getNomeAgenda() {
        return nomeAgenda;
    }

    public List<AgendaCompromisso> getCompromissos() {
        return compromissos;
    }
}
