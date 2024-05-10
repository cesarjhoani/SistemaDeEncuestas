package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {
    public Encuesta crearEncuesta(String titulo);
    public List<Encuesta> obtenerTodasLasEncuestas();

    public Optional<Encuesta> obtenerDetallesDeEncuesta(Long encuestaId);

    public Encuesta actualizarEncuesta(Long encuestaId,String nuevoTitulo);

    public void eliminarEncuesta(Long encuestaId);
}
