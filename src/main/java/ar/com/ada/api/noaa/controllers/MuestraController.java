package ar.com.ada.api.noaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
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

        InfoMuestraResponse respuesta = new InfoMuestraResponse();

        service.crearMuestra(muestra);

        respuesta.muestraId = muestra.getMuestraId();
        respuesta.colorLuz = Boya.ColorEnum.AZUL;

        return ResponseEntity.ok(respuesta);
    }

}
