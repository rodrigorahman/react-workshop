package br.com.workshop.agendabackendapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "agenda_compromisso")
public class AgendaCompromisso implements Serializable {

    @EmbeddedId
    private AgendaCompromissoPK agenda;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_agenda")
    private Date data;

    @Column(name = "ds_compromisso", columnDefinition = "TEXT")
    private String compromisso;

    public AgendaCompromisso(AgendaCompromissoPK agenda, Date data, String compromisso) {
        this.agenda = agenda;
        this.data = data;
        this.compromisso = compromisso;
    }

    public AgendaCompromisso() {
    }

    public AgendaCompromissoPK getAgenda() {
        return agenda;
    }

    public Date getData() {
        return data;
    }

    public String getCompromisso() {
        return compromisso;
    }
}

