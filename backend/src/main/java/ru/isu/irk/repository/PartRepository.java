package ru.isu.irk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
