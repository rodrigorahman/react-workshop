package br.com.workshop.agendabackendapi.repository;

import br.com.workshop.agendabackendapi.entity.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> { }
