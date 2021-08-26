package ar.com.ada.api.noaa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired
    MuestraRepository repo;

    @Autowired
    BoyaService boyaService;

    public void crear(Muestra muestra) {
        repo.save(muestra);
        
    }
    
}
