package com.cesar.SistemaDeEncuestasBackend.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="encuesta")
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @OneToMany(mappedBy = "encuesta",cascade = CascadeType.ALL)
    @JsonIgnore//EVITA QUE SE SERIALIZE EN JSON
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)// Esto permite la deserialización, pero no la serialización osea que se listen sus preguntas en json
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//
    private List<Pregunta> preguntas = new ArrayList<>();

    public Encuesta(Long id, String titulo, List<Pregunta> preguntas) {
        this.id = id;
        this.titulo = titulo;
        this.preguntas = preguntas;
    }

    public Encuesta() {
    }

    public Encuesta(String titulo, List<Pregunta> preguntas) {
        this.titulo = titulo;
        this.preguntas = preguntas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
