package br.com.workshop.agendabackendapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class AgendaCompromissoRS implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime data;
    private String compromisso;

    public AgendaCompromissoRS(@JsonProperty("data") LocalDateTime data, @JsonProperty("compromisso") String compromisso) {
        this.data = data;
        this.compromisso = compromisso;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getCompromisso() {
        return compromisso;
    }
}
