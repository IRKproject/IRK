package ru.isu.irk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.isu.irk.model.Part;
import ru.isu.irk.service.PartService;

@RestController
@RequestMapping("/parts")
public class PartController {
    
    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @ModelAttribute("partTypes")
    public Map<String, String> getPartTypes(){
        Map<String, String> res = new HashMap<>();
        res.put("Body", "Корпус");
        res.put("Plate", "Пластина");
        res.put("Cang", "Цанга");
        res.put("Cang_inner", "Цанг. патрон");
        res.put("Holder", "Б. держатель");
        return res;
    }

    @GetMapping
    @ResponseBody
    public List<Part> listParts() {
        return partService.getAllParts();
    }
    
    @GetMapping("/add")
    public String addPart(Model model) {
        Part part = new Part();
        model.addAttribute("parts", part);
        return "part/addPart";
    }
    
    @PostMapping("/save")
    public Part savePart(@RequestBody Part part) {
        return partService.savePart(part);
    }

    
    @GetMapping("/edit/{partId}")
    public String editPart(@PathVariable("partId") Long partId, Model model) {
        Part part = partService.getPartById(partId);
        model.addAttribute("part", part);
        return "part/editPart";
    }
    
    @PostMapping("/edit/{partId}")
    public Part updatePart(@PathVariable("partId") Long partId,@ModelAttribute("part") Part part) {
        return partService.updatePart(partId, part);
    }

    @GetMapping("/get/{partId}")
    @ResponseBody
    public Part getPart(@PathVariable("partId") Part part){
        return part;
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePart(@PathVariable Long id) {
        partService.deletePart(id);
        return ResponseEntity.ok().build();
    }
    
}
