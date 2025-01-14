package ru.isu.irk.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


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

    @Column(name = "role")
    private String role;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<TechCard> techCards;

    public IRK_Worker(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "ADMIN";
        this.techCards = new ArrayList<>();
    }
    public IRK_Worker() {
        this.username = null;
        this.password = null;
        this.role = null;
        this.techCards = null;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    // @Override
    // public boolean isEnabled() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

}
