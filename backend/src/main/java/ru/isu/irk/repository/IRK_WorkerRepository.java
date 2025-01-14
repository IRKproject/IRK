package ru.isu.irk.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.IRK_Worker;

@Repository
public interface IRK_WorkerRepository extends JpaRepository<IRK_Worker, Long> {
    Optional<IRK_Worker> findByUsername(String username);
}