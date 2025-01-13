package ru.isu.irk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.isu.irk.model.IRK_Worker;
import ru.isu.irk.model.TechCard;
import ru.isu.irk.service.IRK_WorkerService;

@Controller
@RequestMapping("/IRK_Worker")
public class IRK_WorkerController 
{
    private IRK_WorkerService workerService;

    @Autowired
    public IRK_WorkerController(IRK_WorkerService workerService) {
        this.workerService = workerService;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<IRK_Worker> getWorkerById(@PathVariable("id") int id) {
        IRK_Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(worker);
    }*/

    @PostMapping
    public ResponseEntity<IRK_Worker> createWorker(@RequestBody IRK_Worker worker) {
        IRK_Worker createdWorker = workerService.createWorker(worker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorker);
    }

    @PostMapping("/{id}/techcards")
    public ResponseEntity<TechCard> addTechCard(@PathVariable("id") int id, @RequestBody TechCard techCard) {
        TechCard addedTechCard = workerService.addTechCard(id, techCard);
        if (addedTechCard == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTechCard);
    }
    
    @GetMapping("/findTechCardByCardId")
    public String findTechCardByCardId(@RequestParam("cardId") String cardId, Model model) {
        TechCard techCard = workerService.findTechCardByCardId(cardId);
        //if (techCard != null) {
            model.addAttribute("cardId", techCard.getCardId());
            model.addAttribute("instruments", techCard.getInstruments());
            return "searchResult";
        /*} else {
            return "techCardNotFound";
        }*/
    }
    @GetMapping("/{id}")
    public IRK_Worker getIRK_Worker(@PathVariable("id") int id) {
        return workerService.getIRK_WorkerById(id);
    }

    @PostMapping("/")
    public IRK_Worker addIRK_Worker(@RequestBody IRK_Worker worker) {
        return workerService.saveIRK_Worker(worker);
    }

    @PutMapping("/{id}")
    public IRK_Worker updateIRK_Worker(@PathVariable("id") int id, @RequestBody IRK_Worker worker) {
        return workerService.updateIRK_Worker(id, worker);
    }

    @DeleteMapping("/{id}")
    public void deleteIRK_Worker(@PathVariable("id") int id) {
        workerService.deleteIRK_Worker(id);
    }
}
