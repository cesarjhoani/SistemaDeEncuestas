package com.cesar.SistemaDeEncuestasBackend.controlador;

import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;
import com.cesar.SistemaDeEncuestasBackend.modelo.Respuesta;
import com.cesar.SistemaDeEncuestasBackend.servicio.PreguntaService;
import com.cesar.SistemaDeEncuestasBackend.servicio.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/por-encuesta/{encuestaId}")
    public List<Pregunta> obtenerPreguntasPorEncuestas(@PathVariable Long encuestaId){
           return   preguntaService.obtenerPreguntasPorEncuestas(encuestaId);
    }

    @GetMapping("/{preguntaId}")
    public ResponseEntity<Pregunta> obtenerDetallesPregunta(@PathVariable Long preguntaId){
            Optional<Pregunta> optionalPregunta = preguntaService.obtenerDetallesPregunta(preguntaId);
            if(optionalPregunta.isPresent()){
                Pregunta pregunta = optionalPregunta.get();
                return ResponseEntity.ok(pregunta);

            }else {
                return ResponseEntity.notFound().build();
            }
    }

    @PostMapping("/agregar/{encuestaId}")
    public ResponseEntity<Pregunta> agregarPreguntaAEncuesta(@PathVariable Long encuestaId,@RequestBody Pregunta pregunta){
        Pregunta nuevaPregunta = preguntaService.agregarPreguntaAEncuesta(encuestaId,pregunta);
        if(nuevaPregunta!=null){
           return ResponseEntity.ok(nuevaPregunta);//retorno status 200
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{preguntaId}/encuesta/{encuestaId}")
    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable long preguntaId,@RequestBody Pregunta pregunta,@PathVariable Long encuestaId){
        Pregunta preguntaActualizada = preguntaService.actualizarPregunta(preguntaId,pregunta,encuestaId);
        if(preguntaActualizada!=null){
            return ResponseEntity.ok(preguntaActualizada);//retorno status 200
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{preguntaId}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
        return ResponseEntity.noContent().build();//status 204
    }


}
