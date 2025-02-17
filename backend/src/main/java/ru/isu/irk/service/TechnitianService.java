package ru.isu.irk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.Technitian;
import ru.isu.irk.repository.TechnitianRepository;

@Service
public class TechnitianService {

    private final TechnitianRepository technitianRepository;

    @Autowired
    public TechnitianService(TechnitianRepository technitianRepository) {
        this.technitianRepository = technitianRepository;
    }

    public Technitian saveTechnitian(Technitian technitian) {
        return technitianRepository.save(technitian);
    }

    public Technitian getTechnitianById(int id) {
        Optional<Technitian> optionalTechnitian = technitianRepository.findById(id);
        return optionalTechnitian.orElse(null);
    }

    public Technitian updateTechnitian(int id, Technitian technitian) {
        Technitian existingTechnitian = technitianRepository.findById(id).orElse(null);
        //if (existingTechnitian != null) {
            existingTechnitian.setUsername(technitian.getUsername());
            existingTechnitian.setPassword(technitian.getPassword());
            return technitianRepository.save(existingTechnitian);
        /*} else {
            //throw new NotFoundException("Technitian not found with id: " + id);
        }*/
    }

    public void deleteTechnitian(int id) {
        technitianRepository.deleteById(id);
    }
}
