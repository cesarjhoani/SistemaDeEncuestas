package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;
import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;
import com.cesar.SistemaDeEncuestasBackend.repositorio.EncuestaRepository;
import com.cesar.SistemaDeEncuestasBackend.repositorio.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private EncuestaRepository encuestaRepository;


    // este metodo guarda preguntas a encuestas ya existentes
    @Override
    public Pregunta agregarPreguntaAEncuesta(Long encuestaId,Pregunta pregunta) {
        // busco la encuesta por ID para agregarle la nueva pregunta
        Optional<Encuesta> optionalEncuesta = encuestaRepository.findById(encuestaId);

        return optionalEncuesta.map(encuesta -> {
            pregunta.setEncuesta(encuesta);
            pregunta.setRespuestas(new ArrayList<>()); //se deja vacia las respuestas a la pregunta

            encuesta.getPreguntas().add(pregunta);//agregamos la pregunta a las encuesta
            encuestaRepository.save(encuesta);// guardo la encuesta despues de haber agregado las preguntas

            return pregunta; // Devuelvo la pregunta creada
        }).orElseThrow(() -> new NoSuchElementException("No se encontró ninguna encuesta con el ID: " + encuestaId));
    }

// para obtener todas las preguntas que le pertenescan a una encuesta
    @Override
    public List<Pregunta> obtenerPreguntasPorEncuestas(Long encuestaId) {
        return preguntaRepository.findByEncuestaId(encuestaId);
    }


    @Override
    public Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId) {
        return preguntaRepository.findById(preguntaId);
    }

    @Override
    public Pregunta actualizarPregunta(Long preguntaId,Pregunta pregunta, Long encuestaId) {
      return   preguntaRepository.findById(preguntaId).map(preguntaExistente -> {
          preguntaExistente.setContenido(pregunta.getContenido());
          Optional<Encuesta> optionalEncuesta = encuestaRepository.findById(encuestaId);
          //optionalEncuesta.ifPresent(pregunta::setEncuesta);
          if (optionalEncuesta.isPresent()) {
              preguntaExistente.setEncuesta(optionalEncuesta.get());//actualizamos la pregunta a la encuesta
          }
          return preguntaRepository.save(preguntaExistente);
      }).orElse(null);


    }

    @Override
    public void eliminarPregunta(Long preguntaId) {
            preguntaRepository.findById(preguntaId).ifPresent(pregunta -> {
                Encuesta encuesta = pregunta.getEncuesta();//obtenemos la encuesta de la pregunta
                encuesta.getPreguntas().remove(pregunta);// eliminamos la pregunta que desiemos de la lista de preguntas de la encuesta. y asi dañamos su relacion
                preguntaRepository.deleteById(preguntaId);
                encuestaRepository.save(encuesta);// almaceno la encuesta con su pregunta eliminada
            });

    }
}
