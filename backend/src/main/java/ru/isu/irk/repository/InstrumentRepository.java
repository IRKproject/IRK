package ru.isu.irk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.isu.irk.model.Instrument;
import ru.isu.irk.model.Part;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findBySelectedPartsContaining(Part part);
    // public Object findById(Long id);
    // public Object deleteById(Long id);
}
