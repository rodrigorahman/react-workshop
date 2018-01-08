package br.com.workshop.agendabackendapi;

import br.com.workshop.agendabackendapi.entity.Agenda;
import br.com.workshop.agendabackendapi.entity.AgendaCompromisso;
import br.com.workshop.agendabackendapi.entity.Usuarios;
import br.com.workshop.agendabackendapi.model.AgendaRS;
import br.com.workshop.agendabackendapi.repository.AgendaCompromissoRepository;
import br.com.workshop.agendabackendapi.repository.AgendaRepository;
import br.com.workshop.agendabackendapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private AgendaCompromissoRepository agendaCompromissoRepository;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON+";charset=utf-8")
    public List<Usuarios> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON+";charset=utf-8")
    public AgendaRS addAgenda() {

        final Usuarios usuario = service.findOne(1);

        List<AgendaCompromisso> compromissos = new ArrayList<>();
        Agenda a = new Agenda("Agenda 1", usuario, null);
        a = agendaRepository.save(a);

        final AgendaCompromisso compromisso = new AgendaCompromisso(a.getAgendaCode(), new Date(), "Teste Compromisso");
        agendaCompromissoRepository.save(compromisso);


        final Agenda one = agendaRepository.findOne(a.getAgendaCode());

        AgendaRS rs = new AgendaRS(one.getNome(), one.getCompromissos());

        return rs;
    }

}
