package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;
import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta agregarPreguntaAEncuesta(Long encuestaId,Pregunta pregunta);

    List<Pregunta> obtenerPreguntasPorEncuestas(Long encuestaId);

    Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId);

    Pregunta actualizarPregunta(Long preguntaId,Pregunta pregunta,Long encuestaId);//actualizamos la pregunta su contenido y a que encuesta va a pertenecer esa pregunta

    void  eliminarPregunta(Long preguntaId);






}
