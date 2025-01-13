package ru.isu.irk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.model.TechCard;
import ru.isu.irk.service.InstrumentService;
import ru.isu.irk.service.TechCardService;

@Controller
@RequestMapping("/techcards")
public class TechCardController {
    
    private TechCardService techCardService;
    private InstrumentService instrumentService;

    @Autowired
    public TechCardController(InstrumentService instrumentService, TechCardService techCardService) {
        this.techCardService = techCardService;
        this.instrumentService = instrumentService;
    } 
    
    @GetMapping
    public String listParts(Model model) {
        List<TechCard> techCards = techCardService.getAllTechCards();
        model.addAttribute("techCards", techCards);
        return "techCard/listTechCards";
    }

    @GetMapping("/add")
    public String addTechCard(Model model){
        //techCardService.save(techCard);
        List<Instrument> allInstruments = instrumentService.getAllInstruments();
        model.addAttribute("allInstruments", allInstruments);
        model.addAttribute("techCard", new TechCard());
        return "techCard/addTechCard";
    }

    @GetMapping("/edit/{techCardId}")
    public String editTechCard(@PathVariable("techCardId") Long techCardId, Model model) {
        TechCard techCard = techCardService.getTechCardById(techCardId);
        List<Instrument> allInstruments = instrumentService.getAllInstruments();
        List<Instrument> selectedInstruments = techCardService.getSelectedInstruments();

        model.addAttribute("techCard", techCard);
        model.addAttribute("allInstruments", allInstruments);
        model.addAttribute("selectedInstruments", selectedInstruments);

        return "techCard/editTechCard";
    }
    
    @PostMapping("/save")
    public String saveTechCard(@ModelAttribute("techcards") TechCard techCard, @RequestParam(value = "selectedInstruments") List<Long> selectedInstrumentIds) {
        List<Instrument> selectedInstruments = new ArrayList<>();
        for (Long instrumentId : selectedInstrumentIds) {
            Instrument instrument = instrumentService.getInstrumentById(instrumentId);
            selectedInstruments.add(instrument);
        }
        techCard.setSelectedInstruments(selectedInstruments);

        techCardService.saveTechCard(techCard);

        return "redirect:/techcards";
    }
    
    @PostMapping("/update")
    public String updateTechCard(@ModelAttribute("techcards") TechCard techCard) {
        techCardService.updateTechCard(techCard);
        return "redirect:/techcards";
    }
    
    @GetMapping("/delete/{techCardId}")
    public String deleteTechCard(@PathVariable("techCardId") Long techCardId) {
        TechCard techCard = techCardService.getTechCardById(techCardId);
        techCardService.deleteTechCard(techCard);
        return "redirect:/techcards";
    }

}