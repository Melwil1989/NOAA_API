package ar.com.ada.api.noaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.noaa.entities.Boya;
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

        Boya boya = service.crear(infoBoya.longitudInstalacion, infoBoya.latitudInstalacion);

        respuesta.isOk = true;
        respuesta.id = boya.getBoyaId();
        respuesta.message = "La boya ha sido creada correctamente";

        return ResponseEntity.ok(respuesta);

    }
    
}
