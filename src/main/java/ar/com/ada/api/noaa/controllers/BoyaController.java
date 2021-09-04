package ar.com.ada.api.noaa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Boya.ColorEnum;
import ar.com.ada.api.noaa.models.request.InfoBoyaActualizada;
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

    @GetMapping("/api/boyas/{id}")
    public ResponseEntity<Boya> obtenerBoyaPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.obtenerBoyaPorId(id));
    }

    @PutMapping("/api/boyas/{id}/color")
    public ResponseEntity<GenericResponse> actualizarBoya(@PathVariable Integer id, 
                                                            @RequestBody InfoBoyaActualizada boyaActualizada) {

        GenericResponse respuesta = new GenericResponse();

        Boya boya = service.obtenerBoyaPorId(id);
        boya.setColorLuz(boyaActualizada.color);

        service.actualizarBoya(boya);

        respuesta.isOk = true;
        respuesta.id = boya.getBoyaId();
        respuesta.message = "El color de luz de la boya se actualizo con exito";

        return ResponseEntity.ok(respuesta);
    }

}
