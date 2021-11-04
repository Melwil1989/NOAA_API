package ar.com.ada.api.noaa.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Boya.ColorEnum;
import ar.com.ada.api.noaa.repos.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    BoyaRepository repo;

    @Autowired
    MuestraService muestraService;

    public void crear(Boya boya) {

        repo.save(boya);
    }

    public List<Boya> traerBoyas() {

        return repo.findAll();
    }

    public Boya obtenerBoyaPorId(Integer id) {

        Optional<Boya> resultado = repo.findById(id);

        if(resultado.isPresent())
            return resultado.get();

        return null;
    }

    public void actualizarBoya(Boya boya) {
        
        repo.save(boya);
    }

    public void cambiarColorBoya(Boya boya) {

        Boya boyaReseteada = repo.findByBoyaId(boya.getBoyaId());

        boyaReseteada.setColorLuz(ColorEnum.AZUL);

        repo.save(boyaReseteada);
    }

    public boolean existePorId(Integer id) {

        Boya boya = repo.findByBoyaId(id);
        return boya != null;
    }
    
}
