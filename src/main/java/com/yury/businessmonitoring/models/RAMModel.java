/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.models;

import com.yury.businessmonitoring.interfaces.IModel;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Юрий
 */
@Entity
@Table(name = "ram")
public class RAMModel extends IModel{
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int ID;
    
    @Column(name = "free_memory", nullable = false)
    private int freeMemory;
    
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    
    public RAMModel() {}
    
    public RAMModel(int ID, int freeMemory, LocalDateTime date) {
        this.ID = ID;
        this.freeMemory = freeMemory;
        this.date = date;
    }
    
    public RAMModel(int freeMemory) {
        this.freeMemory = freeMemory;
        this.date = LocalDateTime.now();
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }
}
