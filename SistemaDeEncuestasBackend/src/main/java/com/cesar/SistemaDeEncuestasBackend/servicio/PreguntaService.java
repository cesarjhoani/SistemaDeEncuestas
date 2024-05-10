package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta agregarPreguntaAEncuesta(Long encuestaId,String contenido);

    List<Pregunta> obtenerPreguntasPorEncuestas(Long encuestaId);

    Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId);

    Pregunta actualizarPregunta(Long preguntaId,String nuevoContenido,Long encuestaId);//actualizamos la pregunta su contenido y a que encuesta va a pertenecer esa pregunta

    void  eliminarPregunta(Long preguntaId);






}
