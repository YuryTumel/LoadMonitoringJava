/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.models;

import com.yury.businessmonitoring.interfaces.IModel;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Юрий
 */
public class RAMModel extends IModel{
    private int ID;
    private int freeMemory;
    private LocalDateTime date;
    
    public RAMModel (int ID, int freeMemory, LocalDateTime date) {
        this.ID = ID;
        this.freeMemory = freeMemory;
        this.date = date;
    }
    
    public RAMModel(int freeMemory) {
        this.freeMemory = freeMemory;
        this.date = LocalDateTime.now();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * @return the freeMemory
     */
    public int getFreeMemory() {
        return freeMemory;
    }

    /**
     * @param freeMemory the freeMemory to set
     */
    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }
}
