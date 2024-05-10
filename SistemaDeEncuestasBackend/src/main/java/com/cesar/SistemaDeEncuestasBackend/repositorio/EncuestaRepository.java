package com.cesar.SistemaDeEncuestasBackend.repositorio;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta,Long> {

}
