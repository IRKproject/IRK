/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.isu.irk.features.part;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Nikita
 */
@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "specification")
    private String specification;
    
    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
        return "Part{" + "id=" + id + ", type=" + type + ", specification=" + specification + ", quantity=" + quantity + ", reference=" + reference + '}';
    }
    
    @Column(name = "reference")
    private String reference;

    // конструктор класса
    public Part(String type, String specification, int quantity, String reference) {
        this.type = type;
        this.specification = specification;
        this.quantity = quantity;
        this.reference = reference;
    }

    public Part() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    // геттеры и сеттеры для доступа к переменным класса
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
