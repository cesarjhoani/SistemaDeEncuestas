package com.cesar.SistemaDeEncuestasBackend.controlador;

import com.cesar.SistemaDeEncuestasBackend.modelo.Encuesta;
import com.cesar.SistemaDeEncuestasBackend.servicio.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encuestas")
@CrossOrigin("*")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @PostMapping
    public ResponseEntity<Encuesta> crearEncuesta(@RequestBody String titulo) {
        Encuesta encuesta = encuestaService.crearEncuesta(titulo);
        return ResponseEntity.ok(encuesta);
        //return ResponseEntity.created(new URI("/api/encuestas"+encuesta.getId())).body(encuesta);
    }

    @GetMapping
    public List<Encuesta> obtenerTodasLasEncuestas() {
        return encuestaService.obtenerTodasLasEncuestas();
    }

    @GetMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> obtenerDetalleDeLaEncuesta(@PathVariable Long encuestaId) {
        Optional<Encuesta> optionalEncuesta = encuestaService.obtenerDetallesDeEncuesta(encuestaId);
        if (optionalEncuesta.isPresent()) {
            return ResponseEntity.ok(optionalEncuesta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> actualizarEncuesta(@PathVariable Long encuestaId, @RequestBody String nuevoTitulo) {

        Encuesta encuestaActualizada = encuestaService.actualizarEncuesta(encuestaId,nuevoTitulo);
        if (encuestaActualizada != null) {
            return ResponseEntity.ok(encuestaActualizada);
        } else {
            return ResponseEntity.notFound().build();//devolver un 404 que el recurso solicitado no se encontro
        }

    }


    @DeleteMapping("/{encuestaId}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long encuestaId){
        encuestaService.eliminarEncuesta(encuestaId);
        return ResponseEntity.noContent().build();//devolvermos nada solo un  204 indicando que se completo
    }

}
