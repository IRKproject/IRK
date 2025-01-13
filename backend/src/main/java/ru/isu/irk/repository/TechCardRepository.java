package ru.isu.irk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.TechCard;

@Repository
public interface TechCardRepository extends JpaRepository<TechCard, Integer> {
    TechCard findById(long id);
}
