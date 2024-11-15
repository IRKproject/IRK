/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.controller;

/**
 *
 * @author Nikita
 */
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.isu.irk.model.Part;
import ru.isu.irk.service.PartService;

@Controller
@RequestMapping("/parts")
public class PartController {
    
    private PartService partService;

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
    public String listParts(Model model) {
        List<Part> parts = partService.getAllParts();
        model.addAttribute("parts", parts);
        return "listParts";
    }
    
    @GetMapping("/add")
    public String addPart(Model model) {
        Part part = new Part();
        model.addAttribute("parts", part);
        return "addPart";
    }
    
    @PostMapping("/save")
    public String savePart(@ModelAttribute("parts") Part part) {
        partService.savePart(part);
        return "redirect:/parts";
    }
    
    @GetMapping("/edit/{partId}")
    public String editPart(@PathVariable("partId") Long partId, Model model) {
        Part part = partService.getPartById(partId);
        model.addAttribute("part", part);
        return "editPart";
    }
    
    @PostMapping("/update")
    public String updatePart(@ModelAttribute("part") Part part) {
        partService.updatePart(part);
        return "redirect:/parts";
    }

    @GetMapping("/get/{partId}")
    @ResponseBody
    public Part getPart(@PathVariable("partId") Part part){
        return part;
    }
}
