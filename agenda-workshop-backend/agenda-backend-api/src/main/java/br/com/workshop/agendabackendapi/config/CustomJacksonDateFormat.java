package br.com.workshop.agendabackendapi.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class CustomJacksonDateFormat {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(JacksonProperties jacksonProperties) {
        return jacksonObjectMapperBuilder -> {
            String dateFormatStr = jacksonProperties.getDateFormat();
            DateTimeFormatter formatter =
                    dateFormatStr != null && !dateFormatStr.equals("") ? DateTimeFormatter.ofPattern(dateFormatStr) : null;
            jacksonObjectMapperBuilder.modules(
                    new JavaTimeModule()
                            .addSerializer(LocalDate.class, new LocalDateSerializer(formatter))
                            .addSerializer(LocalTime.class, new LocalTimeSerializer(formatter))
                            .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                            .addDeserializer(LocalDate.class, new LocalDateDeserializer(formatter))
                            .addDeserializer(LocalTime.class, new LocalTimeDeserializer(formatter))
                            .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter))
            );
        };
    }
}
