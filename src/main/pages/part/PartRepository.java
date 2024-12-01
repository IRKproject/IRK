/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ru.isu.irk.repository;

/**
 *
 * @author Nikita
 */
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.isu.irk.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    
}
