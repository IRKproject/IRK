package ru.isu.irk.features.techCard;

import ru.isu.irk.features.instrument.*;
// import ru.isu.irk.features.technitian.*;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Past;
//import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;

//import java.time.LocalDate;
//import java.util.ArrayList;

import java.util.List;
//import org.springframework.core.annotation.Order;

@Entity
@Table(name = "tech_card")
public class TechCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    
    @Column(name = "card_id")
    private String cardId;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tech_card_id")
    private List<Instrument> instruments;
    
    @ManyToMany
    @JoinTable(
        name = "techcard_instruments",
        joinColumns = @JoinColumn(name = "tech_card_id"),
        inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    private List<Instrument> selectedInstruments = new ArrayList<>();
    

    public TechCard(String cardId, List<Instrument> selectedInstruments) {
        this.cardId = cardId;
        this.selectedInstruments = selectedInstruments;
    }

    public TechCard() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Instrument> getSelectedInstruments() {
        return selectedInstruments;
    }

    public void setSelectedInstruments(List<Instrument> selectedInstruments) {
        this.selectedInstruments = selectedInstruments;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "TechCard{" + "id=" + id + ", cardId=" + cardId + ", instruments=" + instruments + ", selectedInstruments=" + selectedInstruments + '}';
    }
}

