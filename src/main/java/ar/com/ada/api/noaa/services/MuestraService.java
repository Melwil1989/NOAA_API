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

    public Muestra crearMuestra(Integer boyaId, Date horarioMuestra, double latitud, double longitud, double alturaAlNivelDelMar) {
        
        Muestra muestraNueva = new Muestra();

        muestraNueva.setHorarioMuestra(horarioMuestra);
        muestraNueva.setLatitud(latitud);
        muestraNueva.setLongitud(longitud);
        muestraNueva.setAlturaAlNivelDelMar(alturaAlNivelDelMar);

        Boya boya = boyaService.getBoyaById(boyaId);
        muestraNueva.setBoya(boya);

        muestraNueva = repo.save(muestraNueva); // devuelve la muestra con el ID actualizado

        boya.agregarMuestra(muestraNueva); // agrega la muestra actualizada a la lista de muestras

        //actualizarBoya(boya);

        return muestraNueva;
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
