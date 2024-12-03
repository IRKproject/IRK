/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ru.isu.irk.features.techCard;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
// import ru.isu.irk.model.TechCard;

/**
 *
 * @author Nikita
 */
@Repository
public interface TechCardRepository extends JpaRepository<TechCard, Integer> {
    TechCard findById(int id);
}
