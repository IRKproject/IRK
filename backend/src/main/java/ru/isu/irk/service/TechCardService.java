package ru.isu.irk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.TechCard;
import ru.isu.irk.repository.TechCardRepository;

@Service
public class TechCardService {
    
    private final TechCardRepository techCardRepository;

    @Autowired
    public TechCardService(TechCardRepository techCardRepository) {
        this.techCardRepository = techCardRepository;
    }

    public TechCard getTechCardById(Long techCardId) {
        return techCardRepository.findById(techCardId).get();
    }

    public TechCard updateTechCard(long id, TechCard techCard) {
        System.out.println("Service recive: "+techCard.toString());
        Optional<TechCard> oldTC = techCardRepository.findById(id);
        System.out.println("oldTC recive: "+oldTC.toString());
        if (oldTC.isPresent()) {
            TechCard existingTechCard = oldTC.get();
            
            existingTechCard.setCardId(techCard.getCardId());
            existingTechCard.setSelectedInstruments(techCard.getSelectedInstruments());
            
            return techCardRepository.save(existingTechCard);
        } else {
            throw new RuntimeException("TechCard not found with id " + id);
        }
    }
    public List<TechCard> getAllTechCards() {
        return techCardRepository.findAll();
    }

    public TechCard saveTechCard(TechCard techCard) {
        return techCardRepository.save(techCard);
    }
    
    public void deleteTechCard(TechCard techCard) {
        techCardRepository.delete(techCard);
    }
    public void deleteTechCard(Long id) {
        Optional<TechCard> techCard = techCardRepository.findById(id);
        if (techCard.isPresent()) {
            techCard.get().getSelectedInstruments().clear();
            techCardRepository.save(techCard.get());
    
            techCardRepository.deleteById(id);
        } else {
            throw new RuntimeException("Техкарта с ID " + id + " не найдена");
        }
    }
}