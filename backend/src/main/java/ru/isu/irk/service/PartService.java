package ru.isu.irk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.Part;
import ru.isu.irk.repository.PartRepository;

@Service
public class PartService {
    
    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
    
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }
    
    public Part getPartById(Long id) {
        return partRepository.findById(id).orElse(null);
    }
    
    public void savePart(Part part) {
        partRepository.save(part);
    }
    
    public void updatePart(Part part) {
        partRepository.save(part);
    }

    public void save(Part part) {
        partRepository.save(part);
    }
}
