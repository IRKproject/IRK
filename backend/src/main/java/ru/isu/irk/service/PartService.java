package ru.isu.irk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.model.Part;
import ru.isu.irk.repository.InstrumentRepository;
import ru.isu.irk.repository.PartRepository;

@Service
public class PartService {
    
    private final PartRepository partRepository;
    private final InstrumentRepository instrumentRepository;

    @Autowired
    public PartService(PartRepository partRepository,InstrumentRepository instrumentRepository) {
        this.partRepository = partRepository;
        this.instrumentRepository = instrumentRepository;
    }
    
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }
    
    public Part getPartById(Long id) {
        return partRepository.findById(id).orElse(null);
    }
    
    public Part savePart(Part part) {
        return partRepository.save(part);
    }
    
    public Part updatePart(long id, Part part) {
        Optional<Part> oldPart = partRepository.findById(id);
        oldPart.get().setType(part.getType());
        oldPart.get().setSpecification(part.getSpecification());
        oldPart.get().setQuantity(part.getQuantity());
        oldPart.get().setReference(part.getReference());
        return partRepository.save(part);
    }
    public void deletePart(Long id) {
        Optional<Part> part = partRepository.findById(id);
        if (part.isPresent()) {
            List<Instrument> instruments = instrumentRepository.findBySelectedPartsContaining(part.get());
    
            for (Instrument instrument : instruments) {
                instrument.getSelectedParts().remove(part.get());
                instrumentRepository.save(instrument);
            }
    
            partRepository.deleteById(id);
        } else {
            throw new RuntimeException("Деталь с ID " + id + " не найдена");
        }
    }
}
