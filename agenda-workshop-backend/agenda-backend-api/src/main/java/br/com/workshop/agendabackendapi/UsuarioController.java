package br.com.workshop.agendabackendapi;

import br.com.workshop.agendabackendapi.entity.Usuarios;
import br.com.workshop.agendabackendapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON+";charset=utf-8")
    public List<Usuarios> getAll(){
        return service.getAll();
    }

}
