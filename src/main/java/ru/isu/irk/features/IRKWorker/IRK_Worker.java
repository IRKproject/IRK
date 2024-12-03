/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.features.IRKWorker;

import ru.isu.irk.features.techCard.*;

/**
 *
 * @author Nikita
 */
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "irk_worker")
public class IRK_Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<TechCard> techCards;

    public IRK_Worker(String username, String password) {
        this.username = username;
        this.password = password;
        this.techCards = new ArrayList<>();
    }
    
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

    public List<TechCard> getTechCards() {
        return techCards;
    }

    public void setTechCards(List<TechCard> techCards) {
        this.techCards = techCards;
    }

    //MOVE TO BOTH CONTROLLERS
    public TechCard findTechCardByCardId(String cardId) {
        for (TechCard techCard : techCards) {
            if (techCard.getCardId().equals(cardId)) {
                return techCard;
            }
        }
        return null;
    }
    
    //MOVE TO CONTROLLER
    public void fillOrderTools(TechCard techCard, String tools) 
    {
        // Code to fill the OrderTools document based on the TechCard and tools
    }

    public void fillDefectReport(TechCard techCard, String description) 
    {
        // Code to fill the DefectReport document based on the TechCard and description
    }
}
