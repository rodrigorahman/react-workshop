package br.com.workshop.agendabackendapi.entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AgendaCompromissoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cd_agenda", nullable = false)
    private Agenda pk;

    public AgendaCompromissoPK(Agenda pk) {
        this.pk = pk;
    }

    public AgendaCompromissoPK() {
    }

    public Agenda getPk() {
        return pk;
    }
}
