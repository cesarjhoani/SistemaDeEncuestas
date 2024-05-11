package com.cesar.SistemaDeEncuestasBackend.controlador;

import com.cesar.SistemaDeEncuestasBackend.modelo.Pregunta;
import com.cesar.SistemaDeEncuestasBackend.modelo.Respuesta;
import com.cesar.SistemaDeEncuestasBackend.servicio.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin("*")
public class RespuestaController{

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping("/por-pregunta/{preguntaId}")
    public List<Respuesta> obtenerRespuestasPorPregunta(@PathVariable Long preguntaId){
        return respuestaService.obtenerRespuestasPorPregunta(preguntaId);
    }

    @PostMapping("/agregar/{preguntaId}")
    public ResponseEntity<Respuesta> agregarRespuestaApregunta(@PathVariable Long preguntaId,@RequestBody String contenido){
            Respuesta nuevaRespuesta = respuestaService.agregarRespuestaApregunta(preguntaId,contenido);
           // return ResponseEntity.created(new URI("api/respuestas"+nuevaRespuesta.getId())).body(nuevaRespuesta);
            if(nuevaRespuesta!=null){
               return ResponseEntity.ok(nuevaRespuesta);
            }else {
               return ResponseEntity.notFound().build();
            }
    }

    @GetMapping("/{respuestaId}")
    public ResponseEntity<Respuesta> obtenerDetallesRespuesta(@PathVariable Long respuestaId){
        Optional<Respuesta> optionalRespuesta = respuestaService.obtenerDetallesRespuesta(respuestaId);
       // return  optionalRespuesta.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
        if(optionalRespuesta.isPresent()){
            return ResponseEntity.ok(optionalRespuesta.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{respuestaId}")
    public ResponseEntity<Respuesta> actualizarRespuestaaApregunta(@PathVariable long respuestaId,@RequestBody String nuevoContenido){

        Respuesta respuestaActualizada = respuestaService.actualizarRespuestaaApregunta(respuestaId,nuevoContenido);
        if(respuestaActualizada!=null){
            return ResponseEntity.ok(respuestaActualizada);
        }else {
           return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{respuestaId}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long respuestaId){
        respuestaService.eliminarRespuesta(respuestaId);
        return ResponseEntity.noContent().build();
    }

}
