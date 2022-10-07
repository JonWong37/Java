package com.orca.dojos_ninjas.services;

import com.orca.dojos_ninjas.models.Dojo;
import com.orca.dojos_ninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojo() {
        return dojoRepository.findAll();
    }

    public Dojo save(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    public void delete(Dojo dojo) {
        dojoRepository.delete(dojo);
    }
}
