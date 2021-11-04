package ar.com.ada.api.noaa.services;

import java.util.*;

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
        
        Muestra muestraNueva = new Muestra();

        muestraNueva.setHorarioMuestra(horarioMuestra);
        muestraNueva.setMatriculaEmbarcacion(matriculaEmbarcacion);
        muestraNueva.setLatitud(latitud);
        muestraNueva.setLongitud(longitud);
        muestraNueva.setAlturaAlNivelDelMar(alturaAlNivelDelMar);

        Boya boya = boyaService.obtenerBoyaPorId(boyaId);
        muestraNueva.setBoya(boya);

            if(alturaAlNivelDelMar > 100 || alturaAlNivelDelMar < -100) {
                boya.setColorLuz(ColorEnum.ROJO); 

            } else if(alturaAlNivelDelMar > 50 || alturaAlNivelDelMar < -50)  {
                boya.setColorLuz(ColorEnum.AMARILLO); 
            
            } else {
                boya.setColorLuz(ColorEnum.VERDE); 
            }

        muestraNueva = repo.save(muestraNueva); // devuelve la muestra con el ID actualizado

        boya.agregarMuestra(muestraNueva); // agrega la muestra actualizada a la lista de muestras

        //actualizarBoya(boya);

        return muestraNueva;
    }

    public List<Muestra> obtenerMuestras(Integer idBoya) {
                
        Boya boya = boyaService.obtenerBoyaPorId(idBoya);

        return boya.getMuestras();
    }

    public Muestra obtenerMuestraPorId(Integer id) {

        return repo.findByMuestraId(id);
    }
    
}
