/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.irk.model.IRK_Worker;

/**
 *
 * @author Nikita
 */
@Repository
public interface IRK_WorkerRepository extends JpaRepository<IRK_Worker, Integer> {
    // Дополнительные методы для работы с сущностью IRK_Worker, если необходимо
}
