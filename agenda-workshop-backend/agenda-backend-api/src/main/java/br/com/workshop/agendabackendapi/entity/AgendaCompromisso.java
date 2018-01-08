package br.com.workshop.agendabackendapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "agenda_compromisso")
public class AgendaCompromisso implements Serializable {

    @Id
    @Column(name="cd_agenda")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_agenda")
    private Date data;

    @Column(name = "ds_compromisso", columnDefinition = "TEXT")
    private String compromisso;

    public AgendaCompromisso(Integer id, Date data, String compromisso) {
        this.id = id;
        this.data = data;
        this.compromisso = compromisso;
    }

    public AgendaCompromisso() {
    }

    public Integer getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getCompromisso() {
        return compromisso;
    }
}
