/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isu.irk.model.IRK_Worker;
import ru.isu.irk.model.TechCard;
import ru.isu.irk.model.Technitian;
import ru.isu.irk.repository.IRK_WorkerRepository;

/**
 *
 * @author Nikita
 */
@Service
public class IRK_WorkerService {

    private IRK_WorkerRepository workerRepository;

    @Autowired
    public IRK_WorkerService(IRK_WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public IRK_Worker getWorkerById(int id) {
        return workerRepository.findById(id).orElse(null);
    }

    public IRK_Worker createWorker(IRK_Worker worker) {
        return workerRepository.save(worker);
    }

    public TechCard addTechCard(int workerId, TechCard techCard) {
        IRK_Worker worker = workerRepository.findById(workerId).orElse(null);
        if (worker == null) {
            return null;
        }
        worker.getTechCards().add(techCard);
        //techCard.setWorker(worker);
        workerRepository.save(worker);
        return techCard;
    }

    public void deleteIRK_Worker(int id) {
        workerRepository.deleteById(id);
    }

    public IRK_Worker updateIRK_Worker(int id, IRK_Worker worker) {
        IRK_Worker existingWorker = workerRepository.findById(id).orElse(null);
        //if (existingTechnitian != null) {
            existingWorker.setUsername(worker.getUsername());
            existingWorker.setPassword(worker.getPassword());
            return workerRepository.save(existingWorker);
        /*} else {
            //throw new NotFoundException("Technitian not found with id: " + id);
        }*/
    }

    public IRK_Worker saveIRK_Worker(IRK_Worker worker) {
        return workerRepository.save(worker);
    }

    public IRK_Worker getIRK_WorkerById(int id) {
        Optional<IRK_Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.orElse(null);
    }

    public TechCard findTechCardByCardId(String cardId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
