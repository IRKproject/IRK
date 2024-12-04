package ru.isu.irk.features.techCard;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TechCardRepository extends JpaRepository<TechCard, Integer> {
    TechCard findById(long id);
}
