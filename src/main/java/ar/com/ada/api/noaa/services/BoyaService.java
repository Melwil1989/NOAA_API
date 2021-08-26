package ar.com.ada.api.noaa.services;

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

    public Boya crear(double longitudInstalacion, double latitudInstalacion) {
        
        Boya boya = new Boya();

        repo.save(boya);
        return boya;
    }
    
}
