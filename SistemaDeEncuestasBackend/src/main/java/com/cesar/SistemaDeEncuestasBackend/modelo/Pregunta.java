package com.cesar.SistemaDeEncuestasBackend.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pregunta")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    private Encuesta encuesta;

    @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Pregunta(Long id, String contenido, Encuesta encuesta, List<Respuesta> respuestas) {
        this.id = id;
        this.contenido = contenido;
        this.encuesta = encuesta;
        this.respuestas = respuestas;
    }

    public Pregunta() {
    }

    public Pregunta(String contenido, Encuesta encuesta, List<Respuesta> respuestas) {
        this.contenido = contenido;
        this.encuesta = encuesta;
        this.respuestas = respuestas;
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

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
