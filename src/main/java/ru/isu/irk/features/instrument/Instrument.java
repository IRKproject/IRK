/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.features.instrument;

/**
 *
 * @author Nikita
 */
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import ru.isu.irk.features.part.*;

@Entity
@Table(name = "instrument")
public class Instrument {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    
    @Column(name = "instrument_number")
    private int instrumentNumber;
    
    @ManyToMany
    @JoinTable(
        name = "instrument_parts",
        joinColumns = @JoinColumn(name = "instrument_id"),
        inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    private List<Part> selectedParts = new ArrayList<>();

    public Instrument(int instrumentNumber, ArrayList<Part> parts) {
        this.instrumentNumber = instrumentNumber;
        this.selectedParts = parts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instrument() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(int instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public List<Part> getSelectedParts() {
        return selectedParts;
    }

    public void setSelectedParts(List<Part> selectedParts) {
        this.selectedParts = selectedParts;
    }

    @Override
    public String toString() {
        return "Instrument{" + "id=" + id + ", instrumentNumber=" + instrumentNumber + ", selectedParts=" + selectedParts + '}';
    }
    
    
}
