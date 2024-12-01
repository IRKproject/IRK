package ru.isu.irk.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name = "technitian")
public class Technitian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "technitian", cascade = CascadeType.ALL)
    private List<TechCard> techCards;
    // Add other variables as needed
    
    // Constructor
    public Technitian(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Technitian() {

    }
    
    
    
    // Getters and setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    //MOVE TO CONTROLLER ALL BELOW
    // Method to add a new TechCard to the system
    public void addTechCard(TechCard techCard) {
        techCards.add(techCard);
        //techCard.setTechnitian(this);
    }
    
    // Method to add a new Part to the system
    public void addPart(Part part) {
        // Code to add the Part to the system
    }
    
    // Method to add a new Instrument to the system
    public void addInstrument(Instrument instrument) {
        // Code to add the Instrument to the system
    }
}