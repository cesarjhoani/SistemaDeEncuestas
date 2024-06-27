package com.cesar.SistemaDeEncuestasBackend.servicio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;
import com.cesar.SistemaDeEncuestasBackend.repositorio.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EncuestaServiceImpl implements EncuestaService{

    @Autowired
    private EncuestaRepository encuestaRepository;

    public Encuesta crearEncuesta(Encuesta encuesta) {
        return encuestaRepository.save(encuesta);
    }

    @Override
    public List<Encuesta> obtenerTodasLasEncuestas() {
        return  encuestaRepository.findAll();
    }

    @Override
    public Optional<Encuesta> obtenerDetallesDeEncuesta(Long encuestaId) {
        return encuestaRepository.findById(encuestaId);
    }

        @Override
        public Encuesta actualizarEncuesta(Long encuestaId,Encuesta encuesta) {
            Optional<Encuesta> optionalEncuesta = encuestaRepository.findById(encuestaId);

            if (optionalEncuesta.isPresent()) {
                return encuestaRepository.save(encuesta);
            } else {
                throw new NoSuchElementException("No se encontró ninguna encuesta con el ID: " + encuestaId);
            }
        }



    @Override
    public void eliminarEncuesta(Long encuestaId) {
        encuestaRepository.deleteById(encuestaId);
    }
}
