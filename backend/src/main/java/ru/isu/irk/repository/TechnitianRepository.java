package ru.isu.irk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.Technitian;

/**
 *
 * @author Nikita
 */
@Repository
public interface TechnitianRepository extends JpaRepository<Technitian, Long> {

    public Optional<Technitian> findById(int id);
    // Дополнительные методы репозитория, если требуется

    public void deleteById(int id);
}
