package br.com.workshop.agendabackendapi.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class AgendaCompromissoPK implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cd_agenda", nullable = false)
    private Agenda agenda;

    public AgendaCompromissoPK(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }
}
