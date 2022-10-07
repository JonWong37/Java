package com.orca.dojos_ninjas.services;

import com.orca.dojos_ninjas.models.Ninja;
import com.orca.dojos_ninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjarepository) {
        this.ninjaRepository = ninjarepository;
    }

    public List<Ninja> allNinja() {
        return ninjaRepository.findAll();
    }

    public Ninja save(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    public void delete(Ninja ninja) {
        ninjaRepository.delete(ninja);
    }
}
