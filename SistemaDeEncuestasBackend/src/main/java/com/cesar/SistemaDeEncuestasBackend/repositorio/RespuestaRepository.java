package com.cesar.SistemaDeEncuestasBackend.repositorio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta,Long> {
    List<Respuesta> findByPreguntaId(Long preguntaId);// para listar todas las respuestas de determinada pregunta
}
