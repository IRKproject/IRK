package ru.isu.irk.model;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Past;
//import org.springframework.format.annotation.DateTimeFormat;

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
    private int id;
    
    @Column(name = "card_id")
    private String cardId;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tech_card_id")
    private List<Instrument> instruments;
    
    @ManyToOne
    @JoinColumn(name = "technitian_id")
    private Technitian technitian;
    

    public TechCard(String cardId, List<Instrument> instruments) {
        this.cardId = cardId;
        this.instruments = instruments;
    }

    public TechCard() {
        
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
    
    //MOVE TO CONTROLLER
    // Method to add a new Instrument to the TechCard
    /*public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
        instrument.setTechCard(this);
    }*/

    /*public void setWorker(IRK_Worker worker) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}

