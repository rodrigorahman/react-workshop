package br.com.workshop.agendabackendapi.repository;

import br.com.workshop.agendabackendapi.entity.Agenda;
import br.com.workshop.agendabackendapi.entity.AgendaCompromisso;
import org.springframework.data.repository.CrudRepository;

public interface AgendaCompromissoRepository extends CrudRepository<AgendaCompromisso, Agenda> { }
