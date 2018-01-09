package br.com.workshop.agendabackendapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_agenda")
    private Integer agendaCode;

    @Column(name = "nm_agenda")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cd_usuario", nullable = false)
    private Usuarios usuarios;

    @OneToMany(mappedBy = "agenda.pk")
    private List<AgendaCompromisso> compromissos;

    public Agenda(String nome, Usuarios usuarios, List<AgendaCompromisso> compromissos) {
        this.nome = nome;
        this.usuarios = usuarios;
        this.compromissos = compromissos;
    }

    public Agenda() {
    }

    public Integer getAgendaCode() {
        return agendaCode;
    }

    public String getNome() {
        return nome;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public List<AgendaCompromisso> getCompromissos() {
        return compromissos;
    }
}
