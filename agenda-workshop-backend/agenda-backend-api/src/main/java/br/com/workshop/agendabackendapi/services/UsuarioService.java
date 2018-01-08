package br.com.workshop.agendabackendapi.services;

import br.com.workshop.agendabackendapi.entity.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsuarioService extends CrudRepository<Usuarios, Integer>{

    @Query("select U from Usuarios U")
    List<Usuarios> getAll();

}
