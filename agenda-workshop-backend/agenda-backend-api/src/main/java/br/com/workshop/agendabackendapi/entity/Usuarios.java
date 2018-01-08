package br.com.workshop.agendabackendapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cd_usuario")
    private Integer id;

    @Column(name="nm_usuario")
    private String usuario;

    @Column(name="nm_senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Agenda> agendas;

    public Usuarios(Integer id, String usuario, String senha, List<Agenda> agendas) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.agendas = agendas;
    }

    public Usuarios() {
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }
}
