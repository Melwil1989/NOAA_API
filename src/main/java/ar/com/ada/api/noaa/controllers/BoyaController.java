package ar.com.ada.api.noaa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Boya.ColorEnum;
import ar.com.ada.api.noaa.models.request.InfoBoyaNueva;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/api/boyas")
    public ResponseEntity<GenericResponse> crear(@RequestBody InfoBoyaNueva infoBoya) {

        GenericResponse respuesta = new GenericResponse();

        Boya boya = new Boya(infoBoya.longitudInstalacion, infoBoya.latitudInstalacion);
        boya.setColorLuz(ColorEnum.AZUL);

        service.crear(boya);

        respuesta.isOk = true;
        respuesta.id = boya.getBoyaId();
        respuesta.message = "La boya ha sido creada correctamente";

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/api/boyas")
    public ResponseEntity<List<Boya>> obtenerBoyas() {

        return ResponseEntity.ok(service.traerBoyas());
    }

    /*@PutMapping("/api/boya/{id}")
    public ResponseEntity<?> actualizarBoya() {

    }*/

}
