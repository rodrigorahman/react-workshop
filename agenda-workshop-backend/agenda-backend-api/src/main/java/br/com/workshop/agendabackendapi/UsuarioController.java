package br.com.workshop.agendabackendapi;

import br.com.workshop.agendabackendapi.entity.Agenda;
import br.com.workshop.agendabackendapi.entity.AgendaCompromisso;
import br.com.workshop.agendabackendapi.entity.AgendaCompromissoPK;
import br.com.workshop.agendabackendapi.entity.Usuarios;
import br.com.workshop.agendabackendapi.model.AgendaCompromissoRS;
import br.com.workshop.agendabackendapi.model.AgendaRS;
import br.com.workshop.agendabackendapi.repository.AgendaCompromissoRepository;
import br.com.workshop.agendabackendapi.repository.AgendaRepository;
import br.com.workshop.agendabackendapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        Agenda a = new Agenda("Agenda 1", usuario, compromissos);
        final AgendaCompromisso compromisso = new AgendaCompromisso(new AgendaCompromissoPK(a), new Date(), "Teste Compromisso");
        compromissos.add(compromisso);
        a = agendaRepository.save(a);


//        agendaCompromissoRepository.save(compromisso);


        final Agenda one = agendaRepository.findOne(a.getAgendaCode());

        AgendaRS rs = new AgendaRS(one.getNome(),
                one.getCompromissos().stream().map(c ->
                        new AgendaCompromissoRS(LocalDateTime.ofInstant(c.getData().toInstant(), ZoneId.systemDefault()), c.getCompromisso())).collect(Collectors.toList()));

        return rs;
    }

}
