package ru.isu.irk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.repository.InstrumentRepository;


@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }
    
    public List<Instrument> getAllParts() {
        return instrumentRepository.findAll();
    }

    public Instrument saveInstrument(Instrument instrument) {
        System.out.println(instrument.toString());
        return instrumentRepository.save(instrument);
    }
    public Instrument getInstrumentById(Long id) {
        return (Instrument) instrumentRepository.findById(id);
    }
    
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public Instrument updateInstrument(long id, Instrument instrument) {
        Instrument oldInstrument = (Instrument)instrumentRepository.findById(id);
        oldInstrument.setInstrumentNumber(instrument.getInstrumentNumber());
        oldInstrument.setSelectedParts(instrument.getSelectedParts());
        return instrumentRepository.save(oldInstrument);
    }
}
