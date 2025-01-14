package ru.isu.irk.service;

import java.util.List;
import java.util.Optional;

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
        return instrumentRepository.save(instrument);
    }
    public Instrument getInstrumentById(Long id) {
        return instrumentRepository.findById(id).get();
    }
    
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public Instrument updateInstrument(long id, Instrument instrument) {
        Instrument oldInstrument = instrumentRepository.findById(id).get();
        oldInstrument.setInstrumentNumber(instrument.getInstrumentNumber());
        oldInstrument.setSelectedParts(instrument.getSelectedParts());
        return instrumentRepository.save(oldInstrument);
    }

    public void deleteInstrument(Long id) {
        Optional<Instrument> instrument = instrumentRepository.findById(id);
        if (instrument.isPresent()) {
            instrument.get().getSelectedParts().clear();
            instrumentRepository.save(instrument.get());
    
            instrumentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Инструмент с ID " + id + " не найден");
        }
    }
}
