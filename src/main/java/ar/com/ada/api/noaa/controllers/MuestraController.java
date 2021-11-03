package ar.com.ada.api.noaa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.models.response.InfoMuestraResponse;
import ar.com.ada.api.noaa.services.BoyaService;
import ar.com.ada.api.noaa.services.MuestraService;

@RestController
public class MuestraController {

    @Autowired
    MuestraService service;

    @Autowired
    BoyaService boyaService;

    @PostMapping("/api/muestras")
    public ResponseEntity<InfoMuestraResponse> crear(@RequestBody Muestra muestra) {
        
        muestra = service.crearMuestra(muestra.getBoyaId(), muestra.getHorarioMuestra(), muestra.getMatriculaEmbarcacion(), 
                                muestra.getLatitud(), muestra.getLongitud(), muestra.getAlturaAlNivelDelMar());

        InfoMuestraResponse respuesta = new InfoMuestraResponse();

        respuesta.muestraId = muestra.getMuestraId();
        respuesta.colorLuz = muestra.getBoya().getColorLuz();

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/api/muestras/boyas/{idBoya}")
    public ResponseEntity<List<Muestra>> obtenerMuestras(@PathVariable Integer idBoya) {

        return ResponseEntity.ok(service.obtenerMuestras(idBoya));   
    }

    @DeleteMapping("/api/muestras/{id}")
    public ResponseEntity<GenericResponse> cambiarColorMuestra(@PathVariable Integer id) {

        Muestra muestra = service.obtenerMuestraPorId(id);

        Boya boya = muestra.getBoya();
        boyaService.cambiarColorBoya(boya);

        GenericResponse respuesta = new GenericResponse();

        respuesta.id = id;
        respuesta.isOk = true;
        respuesta.message = "Boya reseteada exitosamente";

        return ResponseEntity.ok(respuesta);
    }

}
