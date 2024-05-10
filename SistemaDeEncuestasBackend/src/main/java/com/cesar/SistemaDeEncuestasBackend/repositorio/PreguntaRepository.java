package com.cesar.SistemaDeEncuestasBackend.repositorio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

    List<Pregunta> findByEncuestaId(Long encuestaId);//para listar todas las preguntas que le pertenecen a una encuesta
}
