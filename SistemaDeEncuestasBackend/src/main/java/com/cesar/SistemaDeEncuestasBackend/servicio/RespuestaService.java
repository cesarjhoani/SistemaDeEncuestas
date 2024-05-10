package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Respuesta;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {

    List<Respuesta> obtenerRespuestasPorPregunta(Long preguntaId);
    Optional<Respuesta> obtenerDetallesRespuesta(Long respuestaId);
    Respuesta agregarRespuestaApregunta(Long preguntaId,String contenido);

    Respuesta actualizarRespuestaaApregunta(Long respuestaId,String nuevoContenido);
    void eliminarRespuesta(Long respuestaId);
}
