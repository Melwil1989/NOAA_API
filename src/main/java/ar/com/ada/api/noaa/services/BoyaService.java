package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
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

    public Boya obtenerBoyaPorId(Integer boyaId) {
        
        return repo.findByBoyaId(boyaId);
    }

    public boolean actualizarBoya(Boya boya) {

        Optional<Boya> resultado = repo.findById(boya.getBoyaId());

        if(resultado.isPresent()) {
            
            return true;
        }
        
        return false;
    }
    
}
