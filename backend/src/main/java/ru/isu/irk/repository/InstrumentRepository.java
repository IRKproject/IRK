package ru.isu.irk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    public Object findById(Long id);
}
