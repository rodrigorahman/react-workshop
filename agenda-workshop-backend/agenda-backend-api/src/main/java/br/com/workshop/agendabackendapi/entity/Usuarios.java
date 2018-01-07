package br.com.workshop.agendabackendapi.entity;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cd_usuario")
    private Long id;
    @Column(name="nm_usuario")
    private String usuario;
    @Column(name="nm_senha")
    private String senha;


    public Usuarios(Long id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuarios() {
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
