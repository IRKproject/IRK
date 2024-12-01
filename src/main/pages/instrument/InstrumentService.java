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
import ru.isu.irk.model.Instrument;
import ru.isu.irk.repository.InstrumentRepository;


@Service
public class InstrumentService {

    private InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }
    
    public List<Instrument> getAllParts() {
        return instrumentRepository.findAll();
    }

    public void saveInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public Instrument getInstrumentById(Long id) {
        return (Instrument) instrumentRepository.findById(id);
    }
    
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public void updateInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }
    
    public void save(Instrument instrument) {
        instrumentRepository.save(instrument);
    }
}
