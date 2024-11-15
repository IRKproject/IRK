/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.service;

/**
 *
 * @author Nikita
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isu.irk.model.Part;
import ru.isu.irk.repository.PartRepository;

@Service
public class PartService {
    
    private PartRepository partRepository;

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
