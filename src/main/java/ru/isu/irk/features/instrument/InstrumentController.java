/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.features.instrument;

// import jakarta.validation.Valid;
// import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.isu.irk.features.part.*;
// import ru.isu.irk.model.Instrument;
// import ru.isu.irk.model.Part;
// import ru.isu.irk.service.InstrumentService;
// import ru.isu.irk.service.PartService;

/**
 *
 * @author Nikita
 */
@Controller
@RequestMapping("/instruments")
public class InstrumentController {

    private InstrumentService instrumentService;
    private PartService partService;

    @Autowired
    public InstrumentController(PartService partService, InstrumentService instrumentService) {
        this.partService = partService;
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public String listInstruments(Model model) {
        List<Instrument> allInstruments = instrumentService.getAllInstruments();
        model.addAttribute("allInstruments", allInstruments);
        return "listInstruments";
    }
    
    @GetMapping("/add")
    public String addInstrument(Model model) {
        List<Part> allParts = partService.getAllParts();
        model.addAttribute("allParts", allParts);
        model.addAttribute("instrument", new Instrument());
        return "addInstrument";
    }
    
    @GetMapping("/edit/{instrumentId}")
    public String editInstrument(@PathVariable("instrumentId") Long instrumentId, Model model) {
        Instrument instrument = instrumentService.getInstrumentById(instrumentId);
        model.addAttribute("instrument", instrument);
        System.out.println(instrumentId);
        System.out.println(instrument);
        return "editInstrument";
    }
    
    @PostMapping("/update")
    public String updateInstrument(@ModelAttribute("instrument") Instrument instrument) {
        instrumentService.updateInstrument(instrument);
        return "redirect:/instruments";
    }
    
    @PostMapping("/save")
    public String saveInstrument(@ModelAttribute("instruments") Instrument instrument) {
        instrumentService.saveInstrument(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Instrument getInstrument(@PathVariable("id") Long id) {
        return instrumentService.getInstrumentById(id);
    }
    
}
