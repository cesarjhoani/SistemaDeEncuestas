package com.cesar.SistemaDeEncuestasBackend.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    //@JsonBackReference//PARA QUE NO SE serialise la referencia ala pregunta
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Pregunta pregunta;

    public Respuesta(Long id, String contenido, Pregunta pregunta) {
        this.id = id;
        this.contenido = contenido;
        this.pregunta = pregunta;
    }

    public Respuesta() {
    }

    public Respuesta(String contenido, Pregunta pregunta) {
        this.contenido = contenido;
        this.pregunta = pregunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
