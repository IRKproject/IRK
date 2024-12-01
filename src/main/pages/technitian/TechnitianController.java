/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isu.irk.model.Technitian;
import ru.isu.irk.service.TechnitianService;

/**
 *
 * @author Nikita
 */
@RestController
@RequestMapping("/technitian")
public class TechnitianController {

    private TechnitianService technitianService;

    @Autowired
    public TechnitianController(TechnitianService technitianService) {
        this.technitianService = technitianService;
    }

    @GetMapping("/{id}")
    public Technitian getTechnitian(@PathVariable("id") int id) {
        return technitianService.getTechnitianById(id);
    }

    @PostMapping("/")
    public Technitian addTechnitian(@RequestBody Technitian technitian) {
        return technitianService.saveTechnitian(technitian);
    }

    @PutMapping("/{id}")
    public Technitian updateTechnitian(@PathVariable("id") int id, @RequestBody Technitian technitian) {
        return technitianService.updateTechnitian(id, technitian);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnitian(@PathVariable("id") int id) {
        technitianService.deleteTechnitian(id);
    }
}
