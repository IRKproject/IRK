package ru.isu.irk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.model.TechCard;
import ru.isu.irk.repository.TechCardRepository;

@Service
public class TechCardService {
    
    private TechCardRepository techCardRepository;
    private List<Instrument> selectedInstruments = new ArrayList<>();

    @Autowired
    public TechCardService(TechCardRepository techCardRepository) {
        this.techCardRepository = techCardRepository;
    }

    public TechCard getTechCardById(Long techCardId) {
        return techCardRepository.findById(techCardId);
    }

    public void updateTechCard(TechCard techCard) {
        techCardRepository.save(techCard);
    }

    public List<TechCard> getAllTechCards() {
        return techCardRepository.findAll();
    }

    public void saveTechCard(TechCard techCard) {
        techCardRepository.save(techCard);
    }
    
    public void save(TechCard techCard) {
        techCardRepository.save(techCard);
    }
    
    public List<Instrument> getSelectedInstruments() {
        return selectedInstruments;
    }
    
    public void addSelectedInstrument(Instrument instrument) {
        selectedInstruments.add(instrument);
    }

    public void deleteTechCard(TechCard techCard) {
        techCardRepository.delete(techCard);
    }
}