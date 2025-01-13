package ru.isu.irk.controller;

// import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.service.InstrumentService;
import ru.isu.irk.service.PartService;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;
    private final PartService partService;

    @Autowired
    public InstrumentController(PartService partService, InstrumentService instrumentService) {
        this.partService = partService;
        this.instrumentService = instrumentService;
    }

    @GetMapping
    @ResponseBody
    public List<Instrument> listInstruments() {
        return instrumentService.getAllInstruments();
    }
    
    // @PostMapping("/save")
    // public Instrument saveInstrument(@RequestBody Instrument instrument) {
    //     return instrumentService.saveInstrument(instrument);
    // }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Instrument getInstrument(@PathVariable("id") Long id) {
        return instrumentService.getInstrumentById(id);
    }

    

    // @GetMapping("/add")
    @PostMapping("/save")
    public Instrument addInstrument(@RequestBody Instrument instrument) {
        return instrumentService.saveInstrument(instrument);
    }

    @PostMapping("/edit/{instrumentId}")
    public Instrument editInstrument(@PathVariable("instrumentId") Long instrumentId, @RequestBody Instrument instrument) {
        return instrumentService.updateInstrument(instrumentId, instrument);
    }
}
