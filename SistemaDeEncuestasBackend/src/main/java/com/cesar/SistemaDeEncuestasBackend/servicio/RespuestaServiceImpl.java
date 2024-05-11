package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;
import com.cesar.SistemaDeEncuestasBackend.modelo.Respuesta;
import com.cesar.SistemaDeEncuestasBackend.repositorio.PreguntaRepository;
import com.cesar.SistemaDeEncuestasBackend.repositorio.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImpl implements RespuestaService{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;


    @Override
    public List<Respuesta> obtenerRespuestasPorPregunta(Long preguntaId) {
        return respuestaRepository.findByPreguntaId(preguntaId);
    }

    @Override
    public Optional<Respuesta> obtenerDetallesRespuesta(Long respuestaId) {
        return respuestaRepository.findById(respuestaId);
    }

    @Override
    public Respuesta agregarRespuestaApregunta(Long preguntaId, String contenido) {
        Optional<Pregunta> optionalPregunta = preguntaRepository.findById(preguntaId);

        return optionalPregunta.map(pregunta -> {
        Respuesta respuesta = new Respuesta();
            respuesta.setContenido(contenido);
            respuesta.setPregunta(pregunta);

            pregunta.getRespuestas().add(respuesta);//agrego la respuesta a una pregunta
            preguntaRepository.save(pregunta);//guardo la pregunta despues de haber agregado sus  respuestas
            return respuesta;

        }).orElse(null);
    }

    @Override
    public Respuesta actualizarRespuestaaApregunta(Long respuestaId, String nuevoContenido) {
        return respuestaRepository.findById(respuestaId)
                .map(respuesta -> {//modifico y actualizo la respuesta
                    respuesta.setContenido(nuevoContenido);
                    return respuestaRepository.save(respuesta);
                }).orElse(null);
    }

    @Override
    public void eliminarRespuesta(Long respuestaId) {
            respuestaRepository.findById(respuestaId).ifPresent(respuesta -> {
                    Pregunta pregunta = respuesta.getPregunta();//obtenemos la pregunta de la respuesta
                    pregunta.getRespuestas().remove(respuesta);//elimino la respuesta asociada a una pregunta
                    respuestaRepository.deleteById(respuestaId);
                    preguntaRepository.save(pregunta);
            });

    }
}
