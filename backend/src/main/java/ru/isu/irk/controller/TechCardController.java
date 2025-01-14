package ru.isu.irk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.isu.irk.model.TechCard;
import ru.isu.irk.service.InstrumentService;
import ru.isu.irk.service.PartService;
import ru.isu.irk.service.TechCardService;

@RestController
@RequestMapping("/techcards")
public class TechCardController {
    
    private final TechCardService techCardService;

    @Autowired
    public TechCardController(InstrumentService instrumentService, TechCardService techCardService,PartService partService) {
        this.techCardService = techCardService;
    } 
    
    @GetMapping
    @ResponseBody
    public List<TechCard> listTechCards(Model model) {
        return techCardService.getAllTechCards();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public TechCard getTechCard(@PathVariable Long id) {
        return techCardService.getTechCardById(id);
    }

    @PostMapping("/save")
    public TechCard saveTechCard(@RequestBody TechCard techCard) {
        return techCardService.saveTechCard(techCard);
    }

    @PostMapping("/edit/{id}")
    public TechCard updateTacTechCard(@PathVariable("id") Long id, @RequestBody TechCard techCard) {
        System.out.println("Controller recive: "+techCard.toString());
        return techCardService.updateTechCard(id, techCard);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTechCard(@PathVariable Long id) {
        techCardService.deleteTechCard(id);
        return ResponseEntity.ok().build();
    }

}