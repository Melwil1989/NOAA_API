package ar.com.ada.api.noaa.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.entities.Boya.ColorEnum;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired
    MuestraRepository repo;

    @Autowired
    BoyaService boyaService;

    public Muestra crearMuestra(Integer boyaId, Date horarioMuestra, String matriculaEmbarcacion, double latitud,
                                double longitud, double alturaAlNivelDelMar) {

        Muestra muestra = new Muestra();
        
        Boya boya = boyaService.findByBoyaId(boyaId);
        boya.setBoyaId(boyaId);

        muestra.setHorarioMuestra(horarioMuestra);
        muestra.setMatriculaEmbarcacion(matriculaEmbarcacion);
        muestra.setLatitud(latitud);
        muestra.setLongitud(longitud);
        muestra.setAlturaAlNivelDelMar(alturaAlNivelDelMar);

        boya.agregarMuestra(muestra);

        return repo.save(muestra);   
    }

    public void cambiarColorLuz(double alturaAlNivelDelMar) {

        Boya boya = new Boya();

        if(alturaAlNivelDelMar > 50 && alturaAlNivelDelMar < 100 || alturaAlNivelDelMar < -50 && alturaAlNivelDelMar > -100) {
            boya.setColorLuz(ColorEnum.AMARILLO); 

        } else if(alturaAlNivelDelMar < 100 && alturaAlNivelDelMar > -100) {
            boya.setColorLuz(ColorEnum.ROJO);
            
        } else 
            boya.setColorLuz(ColorEnum.VERDE); 

    }

    public void crearMuestra(Muestra muestra) {
        repo.save(muestra);
    }
    
}
